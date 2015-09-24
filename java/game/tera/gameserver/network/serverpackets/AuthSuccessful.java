package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

public class AuthSuccessful extends ServerPacket 
{
	private static final ServerPacket instance = new AuthSuccessful();
	
	public static ServerPacket getInstance()
	{
		return instance.newInstance();
	}
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_REMAIN_PLAY_TIME;
	}

	@Override
	protected void writeImpl() 
	{
		writeOpcode();
		writeLong(0x0000000000000006L);
	}
}

