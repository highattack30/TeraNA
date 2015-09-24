package tera.gameserver.network.serverpackets;

import java.nio.ByteBuffer;

import tera.gameserver.network.ServerPacketType;

public class S_Pet_Info_Clear extends ServerConstPacket
{
	private static final S_Pet_Info_Clear instance = new S_Pet_Info_Clear();

	public static S_Pet_Info_Clear getInstance()
	{
		return instance;
	}

	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_PET_INFO_CLEAR;
	}

	@Override
	protected void writeImpl(ByteBuffer buffer)
	{
		writeOpcode(buffer);
	}
}