package tera.gameserver.network.serverpackets;

import java.nio.ByteBuffer;

import tera.gameserver.model.playable.Player;
import tera.gameserver.network.ServerPacketType;

/**
 * Серверный пакет с настройками клиента.
 *
 * @author Ronn Mod Evestu
 */
public class HotKey_S_Load_Client_Account_Setting extends ServerPacket
{
	private static final ServerPacket instance = new HotKey_S_Load_Client_Account_Setting();

	public static HotKey_S_Load_Client_Account_Setting getInstance(Player player)
	{
		HotKey_S_Load_Client_Account_Setting packet = (HotKey_S_Load_Client_Account_Setting) instance.newInstance();

		packet.hotkey = player.getHotkey();

		return packet;
	}

	/** настройки раскладки */
	private byte[] hotkey;

	@Override
	public void finalyze()
	{
		hotkey = null;
	}

	@Override
	public ServerPacketType getPacketType()
	{
		return ServerPacketType.S_LOAD_CLIENT_ACCOUNT_SETTING;
	}

	@Override
	public boolean isSynchronized()
	{
		return false;
	}

	@Override
	protected void writeImpl(ByteBuffer buffer)
	{
		if(hotkey != null)
		{
			writeOpcode(buffer);

			buffer.put(hotkey);
		}
	}
}
