package vanetStuff.mobilities;

import vanetStuff.entities.Vehicle;
import vanetStuff.entities.MobileNode;

public class VehicleMobilityHandler implements MobilityHandler{

	@Override
	public void move(MobileNode mobileNode) {
		Vehicle v = (Vehicle)mobileNode;
		/*debug*/
		System.out.println("VehicleMobilityHandler.move():");
		System.out.println("\t");
		/**/

	}

	

}
