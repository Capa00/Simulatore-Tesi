/**DroneMobilityHandler.java
 * 
//TODO
 *
 */
package vanetStuff.mobilities;

import vanetStuff.entities.Drone;
import vanetStuff.entities.MobileNode;

/**DroneMobilityHandler.java
 * 
//TODO
 *
 */
public class DroneMobilityHandler implements MobilityHandler{

	/* (non-Javadoc)
	 * @see vanetStuff.mobilities.MobilityHandler#move(vanetStuff.entities.MobileNode)
	 */
	@Override
	public void move(MobileNode mobileNode) {
		Drone d = (Drone)mobileNode;
		/*debug*/
		System.out.println("DroneMobilityHandler.move():");
		System.out.println("\t");
		/**/

	}

}
