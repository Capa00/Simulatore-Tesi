package vanetStuff.mobilities;

import vanetStuff.entities.Car;
import vanetStuff.entities.MobileNode;

public class CarMobilityHandler implements MobilityHandler{

	@Override
	public <T extends MobileNode> void move(T mobileNode) {
		Car car = (Car)mobileNode;
	}

	

}
