package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class S_Confirm_Invite_Code_Button extends ServerPacket
{
	private static final ServerPacket instance = new S_Confirm_Invite_Code_Button();
	
	public static ServerPacket getInstance()
	{
		return instance.newInstance();
	}
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_CONFIRM_INVITE_CODE_BUTTON;
	}

	@Override
	protected void writeImpl()
	{
		writeOpcode();
		writeInt(0xE601000F);
		writeInt(0x00560B06);
		writeInt(0);
		writeByte(0);
	}
}