package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class S_Trade_Broker_Highest_Item_Level extends ServerPacket
{
	private static final ServerPacket instance = new S_Trade_Broker_Highest_Item_Level();
	
	public static ServerPacket getInstance()
	{
		return instance.newInstance();
	}
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_TRADE_BROKER_HIGHEST_ITEM_LEVEL;
	}

	@Override
	protected void writeImpl()
	{
		
		//writeOpcode();
		//writeByte(0);
		
	}
}