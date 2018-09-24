package vanetStuff.mobilities;

import vanetStuff.entities.Vehicle;
import vanetStuff.entities.MobileNode;

public class CarMobilityHandler implements MobilityHandler{

	@Override
	public <T extends MobileNode> void move(T mobileNode) {
		Vehicle car = (Vehicle)mobileNode;
	}

	

}
