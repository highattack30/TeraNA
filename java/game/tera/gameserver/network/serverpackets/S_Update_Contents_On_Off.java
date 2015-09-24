package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class S_Update_Contents_On_Off extends ServerPacket
{
	private static final ServerPacket instance = new S_Update_Contents_On_Off();
	private static int Er;
	public static ServerPacket getInstance(int er)
	{
		Er = er;
		return instance.newInstance();
	}
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_UPDATE_CONTENTS_ON_OFF;
	}

	@Override
	protected void writeImpl()
	{
		
		writeOpcode();
		writeByte(Er);
		writeByte(0);
		writeShort(0);
		writeByte(0);
	}
}