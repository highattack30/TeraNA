package tera.remotecontrol.handlers;

import tera.gameserver.model.World;
import tera.remotecontrol.Packet;
import tera.remotecontrol.PacketHandler;
import tera.remotecontrol.PacketType;

/**
 * Сборщик игровой инфы о сервере
 *
 * @author Ronn Mod Evestu
 * @created 25.04.2012
 */
public class GameInfoHandler implements PacketHandler
{
	@Override
	public Packet processing(Packet packet)
	{
		return new Packet(PacketType.REQUEST_GAME_INFO, World.getDroppedItems(), World.getSpawnedNpcs(), World.getKilledNpcs(), World.getKilledPlayers());
	}
}
