/**EventHandler.java
 * 
//TODO
 *
 */
package simulator;

/**EventHandler.java
 * 
//TODO
 * @param <T> 
 *
 */
public interface EventHandler<T extends Entity> {
	void handle(T entity, Event event);
}
