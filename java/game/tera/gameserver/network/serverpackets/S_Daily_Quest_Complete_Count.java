package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class S_Daily_Quest_Complete_Count extends ServerPacket
{
	private static final ServerPacket instance = new S_Daily_Quest_Complete_Count();
	
	public static ServerPacket getInstance()
	{
		return instance.newInstance();
	}
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_BROCAST_GUILD_FLAG;
	}

	@Override
	protected void writeImpl()
	{
		
		writeOpcode();
		writeInt(0x000A0000);
		writeByte(0);
	
	}
}