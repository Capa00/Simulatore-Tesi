package vanetStuff.mobilities;

import vanetStuff.entities.MobileNode;

public interface MobilityHandler {
	<T extends MobileNode> void move(T mobileNode);
}
