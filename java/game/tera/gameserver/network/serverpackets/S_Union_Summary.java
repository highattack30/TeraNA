package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class S_Union_Summary extends ServerPacket
{
	private static final ServerPacket instance = new S_Union_Summary();
	
	public static ServerPacket getInstance()
	{
		return instance.newInstance();
	}
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_UNION_SUMMARY;
	}

	@Override
	protected void writeImpl()
	{
		
		//writeOpcode();
		//writeByte(0);
		 
		
	}
}