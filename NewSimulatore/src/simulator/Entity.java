package simulator;

import vanetStuff.events.EventManager ;

public abstract class Entity {
	private Scheduler scheduler;
	
	public Entity(Scheduler scheduler) {this.scheduler = scheduler;}
	
	public void sendEvent(Event event) {scheduler.addEvent(event);}
	public void setScheduler(Scheduler scheduler) {this.scheduler = scheduler;}
	public Scheduler getScheduler() {return scheduler;}
	
	public abstract EventManager getEventHandler();
		
}
