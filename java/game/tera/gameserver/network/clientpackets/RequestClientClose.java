package tera.gameserver.network.clientpackets;

/**
 * Клиентский пакет для закрытия коннекта с сервером.
 *
 * @author Ronn Mod Evestu
 */
public class RequestClientClose extends ClientPacket
{
	@Override
	protected void readImpl(){}

	@Override
	protected void runImpl()
	{
		owner.close();
	}
}
