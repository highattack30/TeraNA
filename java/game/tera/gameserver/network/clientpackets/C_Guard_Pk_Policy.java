package tera.gameserver.network.clientpackets;

import tera.gameserver.network.serverpackets.S_Guard_Pk_Policy;

/**
 * ÐšÐ»Ð¸ÐµÐ½Ñ‚Ñ�ÐºÐ¸Ð¹ Ð¿Ð°ÐºÐµÑ‚ Ñ‡Ð¸Ñ‚Ð°ÑŽÑ‰Ð¸Ð¹ ÐºÐ»Ð¸ÐµÐ½Ñ‚Ñ�ÐºÐ¸Ð¹ ÐºÐ»ÑŽÑ‡ Ð´Ð»Ñ� ÐºÑ€Ð¸Ð¿Ñ‚Ð¾Ñ€Ð°
 *
 * @author Ronn Mod Evestu
 */
public class C_Guard_Pk_Policy extends ClientPacket
{
	

	public C_Guard_Pk_Policy()
	{
		
	}

	@Override
	public void readImpl()
	{
		
    }

	@Override
	public void runImpl()
	{
				owner.sendPacket(S_Guard_Pk_Policy.getInstance(), true);
	}
}