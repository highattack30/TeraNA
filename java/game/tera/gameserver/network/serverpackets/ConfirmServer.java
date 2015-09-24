package tera.gameserver.network.serverpackets;

import java.nio.ByteBuffer;

import tera.gameserver.network.ServerPacketType;


/**
 * Пакет ответа на запрос проверки сервера
 * 
 * @author Ronn Mod Evestu
 * @created 25.03.2012
 */
public class ConfirmServer extends ServerPacket
{
	private static final ServerPacket instance = new ConfirmServer();
	
	public static ConfirmServer getInstance(int index)
	{
		ConfirmServer packet = (ConfirmServer) instance.newInstance();
		
		packet.index = index;
		
		return packet;
	}
	
	/** индекс подтверждения */
	private int index;
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_REIGN_INFO;
	}
	
	@Override
	public boolean isSynchronized()
	{
		return false;
	}
	
	@Override
	protected void writeImpl(ByteBuffer buffer)
	{
		writeOpcode(buffer);
		writeShort(buffer,0);
		writeShort(buffer,0);
		writeInt(buffer, index);
		int shift1 = buffer.position();
		buffer.position(4);
		writeShort(buffer,shift1);
		buffer.position(shift1);
		writeShort(buffer,0);
		int shift2 = buffer.position();
		buffer.position(8);
		writeShort(buffer,shift2);
		buffer.position(shift2);
		writeShort(buffer,0);
	}
}