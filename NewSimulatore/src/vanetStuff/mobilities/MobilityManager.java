package vanetStuff.mobilities;

import java.util.HashMap;

import vanetStuff.entities.MobileNode;

public class MobilityManager {
	private HashMap<Class<? extends MobileNode>, MobilityHandler> raccoltaMobilita = new HashMap<>();
	
	public void move(MobileNode mobileNode) {
		
		/*debug*/
		System.out.println("MobilityManager.move("+mobileNode.getId()+"):");
		/**/

		MobilityHandler m = raccoltaMobilita.get(mobileNode.getClass());
		if(m == null) {
			m = mobileNode.getMobilityHandler();
			raccoltaMobilita.put(mobileNode.getClass(), m);
		}
		
		m.move(mobileNode);
	}
}
