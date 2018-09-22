package vanetStuff.mobilities;

import java.util.HashMap;

import vanetStuff.entities.MobileNode;

public class MobilityManager {
	private HashMap<Class<? extends MobileNode>, MobilityHandler> raccoltaMobilita;
	
	public void move(MobileNode mobileNode) {
		MobilityHandler m = raccoltaMobilita.get(mobileNode.getClass());
		if(m == null) {
			m = mobileNode.getMobilityHandler();
			raccoltaMobilita.put(mobileNode.getClass(), m);
		}
		
		m.move(mobileNode);
	}
}
