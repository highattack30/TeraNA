package tera.gameserver.network.serverpackets;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import tera.gameserver.model.equipment.Equipment;
import tera.gameserver.model.equipment.SlotType;
import tera.gameserver.model.playable.Player;
import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class S_User_Item_Equip_Changer extends ServerPacket
{
	private static final ServerPacket instance = new S_User_Item_Equip_Changer();
	
	public static S_User_Item_Equip_Changer getInstance(Player player)
	{
		
//		S_User_Item_Equip_Changer packet = (S_User_Item_Equip_Changer) instance.newInstance();
//
//		// получаем промежуточный буффер
//		ByteBuffer buffer = packet.getPrepare();
//
//		try
//		{
//			Equipment equipment = player.getEquipment();
//			
//			packet.writeInt(buffer, player.getObjectId());// уник ид игрока
//			packet.writeInt(buffer, player.getSubId());
//
//			
//			equipment.lock();
//			try
//			{
//				int count = SlotType.SIZE;
//				for (int i = 0 ;i < count; ++i)
//				{
//					
//					packet.writeInt(buffer, equipment.getItemId(SlotType.SLOT_WEAPON));
//					packet.writeInt(buffer, equipment.getItemId(SlotType.SLOT_ARMOR));
//					packet.writeInt(buffer, equipment.getItemId(SlotType.SLOT_BOOTS));
//					packet.writeInt(buffer, equipment.getItemId(SlotType.SLOT_GLOVES));
//					packet.writeInt(buffer, equipment.getItemId(SlotType.SLOT_MASK));
//					packet.writeInt(buffer, equipment.getItemId(SlotType.SLOT_HAT));
//
//				}
//			
//			}
//			finally
//			{
//				equipment.unlock();
//			}
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeInt(buffer,0);
//			packet.writeByte(buffer,1);
//			return packet;
//		}
//		finally
//		{
//			buffer.flip();
//		}
	return null;
	}
	/** промежуточный буффер */
	private final ByteBuffer prepare;

	public S_User_Item_Equip_Changer()
	{
		this.prepare = ByteBuffer.allocate(4096).order(ByteOrder.LITTLE_ENDIAN);
	}

	@Override
	public void finalyze()
	{
		prepare.clear();
	}

	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_USER_ITEM_EQUIP_CHANGER;
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

	/**
	 * @return подготовленный буфер.
	 */
	public ByteBuffer getPrepare()
	{
		return prepare;
	}
}