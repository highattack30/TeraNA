package tera.gameserver.network.serverpackets;

import tera.gameserver.network.ServerPacketType;

/**
 * @author Ronn Mod Evestu
 */
public class S_Brocast_Guild_Flag extends ServerPacket
{
	private static final ServerPacket instance = new S_Brocast_Guild_Flag();
	
	public static ServerPacket getInstance()
	{
		return instance.newInstance();
	}
	
	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_BROCAST_GUILD_FLAG;
	}

	@Override
	protected void writeImpl()
	{
		
		writeOpcode();
		writeByte(0);
		 
		/* 1200 // skip 18 bytes to next shift for more guild if not then after the 18 byte skip 0000 = no more guild flags
         * 0800 // possion first main call
         * 0800 // first main call
         * 1400 // first start call
         * 1200 // skip 18 bytes to first guid name start
         * 0D000000 // dword id ??
         * 0000 // first 2 byte blank shift

         * 1400 // first start call
         * 4800 // next shift address if more guilds if not then 0000
         * 1E00 // start of guild name write address
         * 01000000 // maybe id ???
         * 6700750069006C00640066006C00610067005F0034003000320034005F00320034003800390038005F003100 // name guildflag_4024_24898_1
         * 0000 // always at end of guild flags 2 byte blank shift
         */

        /*

         * 5003 > base start write
         * 8803 > id 1 next call
         * 5A03 > id 2 name start
         * 11000000
         *
         *
         * 8803
         * 0000
         * 9203

         * 09000000
         * 6700750069006C00640066006C00610067005F0034003000320034005F00320034003800390038005F003100
         * 0000
         */
	
	}
}