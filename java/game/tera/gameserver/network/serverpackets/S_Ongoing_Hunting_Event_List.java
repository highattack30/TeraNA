package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class S_Ongoing_Hunting_Event_List extends ServerPacket
{
	private static final ServerPacket instance = new S_Ongoing_Hunting_Event_List();
	
	public static ServerPacket getInstance()
	{
		return instance.newInstance();
	}
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_ONGOING_HUNTING_EVENT_LIST;
	}

	@Override
	protected void writeImpl()
	{
		
		writeOpcode();
		writeInt(0);
	
	}
}