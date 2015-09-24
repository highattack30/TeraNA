package tera.remotecontrol;

/**
 * Интерфейс для обработчика пакетов
 *
 * @author Ronn Mod Evestu
 * @created 26.03.2012
 */
public interface PacketHandler
{
	/**
	 * Обработка указанного пакета
	 * 
	 * @param packet
	 */
	public abstract Packet processing(Packet packet);
}
