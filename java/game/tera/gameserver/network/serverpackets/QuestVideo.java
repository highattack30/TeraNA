package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class QuestVideo extends ServerPacket
{
	private static final ServerPacket instance = new QuestVideo();
	
	public static QuestVideo getInstance(int id)
	{
		QuestVideo packet = (QuestVideo) instance.newInstance();
		
		packet.id = id;
		
		return packet;
	}
	
	/** ид ролика */
	private int id;
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_PLAY_MOVIE;
	}

	@Override
	protected void writeImpl()
	{
		writeOpcode();
		writeInt(id);//02 00 00 00     Номер Ролика
	}
}
