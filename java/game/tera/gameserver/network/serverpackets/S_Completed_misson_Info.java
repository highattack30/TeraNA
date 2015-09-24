package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class S_Completed_misson_Info extends ServerPacket
{
	private static final ServerPacket instance = new S_Completed_misson_Info();
	
	public static ServerPacket getInstance()
	{
		return instance.newInstance();
	}
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_COMPLETED_MISSION_INFO;
	}

	@Override
	protected void writeImpl()
	{
		
		writeOpcode();
		writeInt(0);
		 
	
	}
}