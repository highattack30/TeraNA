package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class S_Can_Create_User extends ServerPacket
{
	private static final ServerPacket instance = new S_Can_Create_User();
	
	public static ServerPacket getInstance()
	{
		return instance.newInstance();
	}
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_CAN_CREATE_USER;
	}

	@Override
	protected void writeImpl()
	{
		writeOpcode();
		writeByte(1);
	}
}