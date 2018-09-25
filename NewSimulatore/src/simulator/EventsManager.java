/**EventManager.java
 * 
//TODO
 *
 */
package simulator;

import java.util.HashMap;

/**EventManager.java
 * 
//TODO
 *
 */
public class EventsManager {
	private HashMap<String, EventHandler> raccoltaHandler = new HashMap<>();
	
	public void action(Event event) {
		/*debug*/
		System.out.println("\t");
		System.out.println("EventManager.action("+event.getName()+"):");
		/**/


		EventHandler m = raccoltaHandler.get(event.getName());
		if(m == null) {
			m = event.getEventHandler();

			/*debug*/
			System.out.println("\t "+m);
			/**/

			raccoltaHandler.put(event.getName(), m);
		}
		
		m.handle(event);
	}
}
