package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class S_Load_Account_Setting extends ServerPacket
{
	private static final ServerPacket instance = new S_Load_Account_Setting();
	
	public static ServerPacket getInstance()
	{
		return instance.newInstance();
	}
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_LOAD_CLIENT_ACCOUNT_SETTING;
	}

	@Override
	protected void writeImpl()
	{
		
		writeOpcode();
		writeShort(0x0008);
		writeShort(0);
	}
}