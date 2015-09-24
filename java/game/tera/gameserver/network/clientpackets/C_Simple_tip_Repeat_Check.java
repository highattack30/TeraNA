package tera.gameserver.network.clientpackets;

import tera.gameserver.network.serverpackets.S_Simple_Tip_repeat_Check;
import tera.gameserver.network.serverpackets.ServerKey;

/**
 * ÐšÐ»Ð¸ÐµÐ½Ñ‚Ñ�ÐºÐ¸Ð¹ Ð¿Ð°ÐºÐµÑ‚ Ñ‡Ð¸Ñ‚Ð°ÑŽÑ‰Ð¸Ð¹ ÐºÐ»Ð¸ÐµÐ½Ñ‚Ñ�ÐºÐ¸Ð¹ ÐºÐ»ÑŽÑ‡ Ð´Ð»Ñ� ÐºÑ€Ð¸Ð¿Ñ‚Ð¾Ñ€Ð°
 *
 * @author Ronn Mod Evestu
 */
public class C_Simple_tip_Repeat_Check extends ClientPacket
{
	private static int va;

	public C_Simple_tip_Repeat_Check()
	{
		
	}

	@Override
	public void readImpl()
	{
		va = readInt();
    }

	@Override
	public void runImpl()
	{
				owner.sendPacket(S_Simple_Tip_repeat_Check.getInstance(va), true);
	}
}