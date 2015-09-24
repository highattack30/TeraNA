package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class AuthSuccessful2 extends ServerPacket
{
	private static final ServerPacket instance = new AuthSuccessful2();
	
	public static ServerPacket getInstance()
	{
		return instance.newInstance();
	}
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_LOGIN_ARBITER;
	}

	@Override
	protected void writeImpl()
	{
		writeOpcode();
		writeLong(0x0000000000000001L);
		writeLong(0x0000000000060000L);
		writeShort(0);
		writeByte(0); 
	}
}