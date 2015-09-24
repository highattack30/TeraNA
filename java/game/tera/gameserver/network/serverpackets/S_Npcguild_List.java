package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class S_Npcguild_List extends ServerPacket
{
	private static final ServerPacket instance = new S_Npcguild_List();
	
	public static ServerPacket getInstance()
	{
		return instance.newInstance();
	}
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_NPCGUILD_LIST;
	}

	@Override
	protected void writeImpl()
	{
		
		writeOpcode();
		writeInt(0);
		writeInt(0x0FAC2722);
		writeInt(0x00008000);
	}
}