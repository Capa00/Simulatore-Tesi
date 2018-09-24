package simulator;

public abstract class Entity {
	private Scheduler scheduler;
	protected Simulation<? extends Parameter, ? extends Scenario> simulation;
	
	public Entity(Simulation<? extends Parameter, ? extends Scenario> simulation) {
		this.simulation = simulation;
		this.scheduler = simulation.getScheduler();
	}
	
	public void sendEvent(Event event) {scheduler.addEvent(event);}
	public void setScheduler(Scheduler scheduler) {this.scheduler = scheduler;}
	public Scheduler getScheduler() {return scheduler;}
	
	public abstract EventHandler<? extends Entity> getEventHandler();
		
}
