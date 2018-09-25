/**EventHandler.java
 * 
//TODO
 *
 */
package simulator;

/**EventHandler.java
 * 
 */
public interface EventHandler {
	<T extends Event> void handle(T event);
}
