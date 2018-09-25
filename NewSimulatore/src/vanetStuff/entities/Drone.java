/**Drone.java
 * 
//TODO
 *
 */
package vanetStuff.entities;

import simulatorVanet.VanetSimulation;
import vanetStuff.mobilities.DroneMobilityHandler;
import vanetStuff.mobilities.MobilityHandler;

/**Drone.java
 * 
 */
@Deprecated
public class Drone extends MobileNode{

	/**
	 * @param clazz
	 * @param simulation
	 * @param id
	 */
	public Drone(String clazz, VanetSimulation simulation, String id) {
		super(clazz, simulation, id);
	}

	/* (non-Javadoc)
	 * @see vanetStuff.entities.MobileNode#getMobilityHandler()
	 */
	@Override
	public MobilityHandler getMobilityHandler() {
		return new DroneMobilityHandler();
	}

}
