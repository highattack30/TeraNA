package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class S_Guard_Pk_Policy extends ServerPacket
{
	private static final ServerPacket instance = new S_Guard_Pk_Policy();
	
	public static ServerPacket getInstance()
	{
		return instance.newInstance();
	}
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_GUARD_PK_POLICY;
	}

	@Override
	protected void writeImpl()
	{
		
		writeOpcode();
		writeByte(1);
	
	}
}