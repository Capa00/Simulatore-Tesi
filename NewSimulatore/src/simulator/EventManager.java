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
public class EventManager {
	private HashMap<Class<? extends Entity>, EventHandler<? extends Entity>> raccoltaHandler = new HashMap<>();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void handle(Entity entity, Event event) {
		/*debug*/
		System.out.println("EventManager.handle():");
		/**/

		EventHandler m = raccoltaHandler.get(entity.getClass());
		if(m == null) {
			m = entity.getEventHandler();
			System.out.println("\t "+m);
			raccoltaHandler.put(entity.getClass(), m);
		}
		
		m.handle(entity, event);
	}
}
