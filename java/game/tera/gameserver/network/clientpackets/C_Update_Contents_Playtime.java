package tera.gameserver.network.clientpackets;

/**
 * Visible Range Set
 *
 * @author Evestu
 */
public class C_Update_Contents_Playtime extends ClientPacket
{
	private byte[] data;
	@Override
	protected void readImpl(){
		//readBytes(data);
	}

	@Override
	protected void runImpl()
	{
	// just let it read for now
	}
}
