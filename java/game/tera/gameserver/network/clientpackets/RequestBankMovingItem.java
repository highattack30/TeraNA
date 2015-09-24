package tera.gameserver.network.clientpackets;

import tera.gameserver.model.npc.interaction.dialogs.BankDialog;
import tera.gameserver.model.npc.interaction.dialogs.Dialog;
import tera.gameserver.model.playable.Player;

/**
 * ÐšÐ»Ð¸ÐµÐ½Ñ‚Ñ�ÐºÐ¸Ð¹ Ð¿Ð°ÐºÐµÑ‚, ÑƒÐºÐ°Ð·Ñ‹Ð²Ð°ÑŽÑ‰Ð¸Ð¹ ÐºÐ°ÐºÐ¾Ð¹ Ð¸Ñ‚ÐµÐ¼ Ñ…Ð¾Ñ‚Ð¸Ð¼ Ð¿ÐµÑ€ÐµÐ¼ÐµÑ�Ñ‚Ð¸Ñ‚ÑŒ Ð² Ð¸Ð½Ð²ÐµÐ½Ñ‚Ð¾Ñ€Ðµ
 *
 * @author Ronn Mod Evestu
 */
public class RequestBankMovingItem extends ClientPacket
{
	/** Ð¸Ð½Ð´ÐµÐºÑ� Ñ�Ñ‚Ð°Ñ€Ð¾Ð¹ Ñ�Ñ‡ÐµÐ¹ÐºÐ¸ */
	private int oldDell;
	/** Ð¸Ð½Ð´ÐµÐºÑ� Ð½Ð¾Ð²Ð¾Ð¹ Ñ�Ñ‡ÐµÐ¹ÐºÐ¸ */
	private int newDell;

	/** Ð¸Ð³Ñ€Ð¾Ðº */
	private Player player;

	@Override
	public void finalyze()
	{
		player = null;
	}

	@Override
	public boolean isSynchronized()
	{
		return false;
	}

	@Override
	public void readImpl()
	{
		player = owner.getOwner();

		readLong();
		readLong();

		readInt();

		oldDell = readInt();
		newDell = readInt();
	}

	@Override
	public void runImpl()
	{
		if(player == null)
			return;

		// Ð¿Ð¾Ð»ÑƒÑ‡Ð°ÐµÐ¼ Ð´Ð¸Ð°Ð»Ð¾Ð³ Ð±Ð°Ð½ÐºÐ°
		Dialog dialog = player.getLastDialog();

		// ÐµÑ�Ð»Ð¸ ÐµÐ³Ð¾ Ð½ÐµÑ‚, Ð²Ñ‹Ñ…Ð¾Ð´Ð¸Ð¼
		if(dialog == null || !(dialog instanceof BankDialog))
			return;

		BankDialog bank = (BankDialog) dialog;

		bank.movingItem(oldDell, newDell);
	}
}