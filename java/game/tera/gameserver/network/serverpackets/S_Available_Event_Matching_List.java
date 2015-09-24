package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class S_Available_Event_Matching_List extends ServerPacket
{
	private static final ServerPacket instance = new S_Available_Event_Matching_List();
	
	public static ServerPacket getInstance()
	{
		return instance.newInstance();
	}
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_AVAILABLE_EVENT_MATCHING_LIST;
	}

	@Override
	protected void writeImpl()
	{
		writeOpcode();
		writeInt(0);
		writeInt(0);
		writeInt(0);
		writeInt(0);
		writeInt(0);
		writeInt(0);
		writeInt(0);
		writeInt(0);
		writeInt(0);
		writeInt(0);
		writeInt(0);
		writeInt(0);
		writeInt(0x00010000);
		writeShort(0);
	
	}
}