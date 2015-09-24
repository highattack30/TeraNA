package tera.gameserver.network.clientpackets;

import tera.gameserver.network.serverpackets.S_Can_Create_User;

/**
 * ÐšÐ»Ð¸ÐµÐ½Ñ‚Ñ�ÐºÐ¸Ð¹ Ð¿Ð°ÐºÐµÑ‚ Ð´Ð»Ñ� Ñ�Ð¾Ð·Ð´Ð°Ð½Ð¸Ñ� Ð¿ÐµÑ€Ñ�Ð¾Ð½Ð°Ð¶Ð°
 *
 * @author Ronn Mod Evestu
 */
public class RequestNewCreatePlayer extends ClientPacket
{
	@Override
	public void readImpl()
	{
		
    }

	@Override
	public void runImpl()
	{
		owner.sendPacket(S_Can_Create_User.getInstance(), true);
	}
}