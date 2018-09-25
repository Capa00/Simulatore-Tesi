package vanetStuff.mobilities;

import vanetStuff.entities.Vehicle;
import vanetStuff.entities.MobileNode;

public class VehicleMobilityHandler implements MobilityHandler{

	@Override
	public <T extends MobileNode> void move(T mobileNode) {
		Vehicle v = (Vehicle)mobileNode;
		/*debug*/
		System.out.println("VehicleMobilityHandler.move():");
		System.out.println("\t");
		/**/

	}

	

}
