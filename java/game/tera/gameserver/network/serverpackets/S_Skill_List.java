package tera.gameserver.network.serverpackets;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import rlib.util.array.Array;
import rlib.util.array.Arrays;
import rlib.util.table.IntKey;
import rlib.util.table.Table;
import tera.gameserver.model.playable.Player;
import tera.gameserver.model.skillengine.Skill;
import tera.gameserver.network.ServerPacketType;

/**
 * Список скилов игрока.
 *
 * @author Ronn Mod Evestu
 */
public final class S_Skill_List extends ServerPacket
{
	private static final ServerPacket instance = new S_Skill_List();

	public static S_Skill_List getInstance(Player player)
	{
		S_Skill_List packet = (S_Skill_List) instance.newInstance();

		// получаем подготавливаемый буффер
		ByteBuffer buffer = packet.getPrepare();

		try
		{
			// получаем скилы игрока
			Table<IntKey, Skill> table = player.getSkills();

			// получаем список скилов
			Array<Skill> skills = table.values(packet.getSkills());

			// получаем массив скилов
			Skill[] array = skills.array();

			int counter = 0;
			int skillsint = 0;
			int index = 8;

			// подсчитываем кол-во скилов в книге
			for(int i = 0, length = skills.size(); i < length; i++)
			{
				Skill skill = array[i];

				if(skill.getLevel() < 2 && skill.isVisibleOnSkillList())
					counter++;
			}

			int here = buffer.position();
			packet.writeShort(buffer, 0);
			packet.writeShort(buffer, 8);
			
			// если есть скилы
			if(counter > 0)
			{
				// запись классовых активных скилов
				for(int i = 0, length = skills.size(); i < length; i++)
				{
					Skill skill = array[i];

					if(skill.getLevel() < 2 && skill.isVisibleOnSkillList())
					{
						counter--;

						packet.writeShort(buffer, index);

						if(counter == 0)
							index = 0;
						else
							index += 10;

						packet.writeShort(buffer, index);
						packet.writeInt(buffer, skill.getId());
						packet.writeShort(buffer, skill.isActive()? 1 : 0);
					++skillsint;
					}
				}
			}
			//added because old way was static fail .....
			int hereend = buffer.position();
			buffer.position(here);
			packet.writeShort(buffer, skillsint);
			buffer.position(hereend);
			return packet;
		}
		finally
		{
			buffer.flip();
		}
	}

	/** список скилов игрока */
	private final Array<Skill> skills;

	/** промежуточный буффер */
	private final ByteBuffer prepare;

	public S_Skill_List()
	{
		this.skills = Arrays.toArray(Skill.class);
		this.prepare = ByteBuffer.allocate(4096).order(ByteOrder.LITTLE_ENDIAN);
	}

	@Override
	public void finalyze()
	{
		prepare.clear();
		skills.clear();
	}

	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_SKILL_LIST;
	}

	/**
	 * @return подготовленный буфер.
	 */
	public ByteBuffer getPrepare()
	{
		return prepare;
	}

	/**
	 * @return список скилов.
	 */
	public Array<Skill> getSkills()
	{
		return skills;
	}

	@Override
	public boolean isSynchronized()
	{
		return false;
	}

	@Override
	protected void writeImpl(ByteBuffer buffer)
	{
		writeOpcode(buffer);		

		// получаем промежуточный буффер
		ByteBuffer prepare = getPrepare();

		// переносим данные
		buffer.put(prepare.array(), 0, prepare.limit());
	}
}