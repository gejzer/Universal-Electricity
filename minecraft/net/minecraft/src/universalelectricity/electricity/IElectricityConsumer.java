package net.minecraft.src.universalelectricity.electricity;

import net.minecraft.src.universalelectricity.extend.IDisableable;


/**
 * The UEIConsumer interface is an interface that must be applied to all tile entities that can receive electricity.
 * @author Calclavia
 *
 */
public interface IElectricityConsumer extends IDisableable
{
	/**
	 * onRecieveElectricity is called whenever a Universal Electric conductor sends a packet of electricity to the consumer (which is this block).
	 * @param watts - The amount of watts this block received.
	 * @param voltage - The voltage the tile entity is receiving.
	 * @param side - The side of the block in which the electricity came from.
	 * @return watts - The amount of rejected power to be sent back into the conductor
	 */
	public double onReceiveElectricity(double watts, int voltage, byte side);
	
	/**
	 * You can use this to check if a wire can connect to this UE consumer to properly render the graphics
	 * @param side - The side in which the electricity is coming from.
	 * @return Returns true or false if this consumer can receive electricity at this given tick or moment.
	 */
	public boolean canReceiveElectricity(byte side);
	
	/**
	 * @return Return the stored electricity in this consumer. Called by conductors to spread electricity to this unit.
	 */
	public double getStoredElectricity();
	
	/**
	 * @return Return the maximum amount of stored electricity this consumer can get.
	 */
	public double getElectricityCapacity();
	
	/**
	 * Gets the voltage of the electricity consumer. Used in a conductor to find the voltage difference.
	 * If the voltage is too high, things might explode.
	 * @return The amount of volts. E.g 120v or 240v
	 */
	public int getVolts();
}