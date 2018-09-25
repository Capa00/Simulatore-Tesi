package simulator;

public abstract class Entity<T extends Simulation<? extends Parameter, ? extends Scenario>> {
	private Scheduler scheduler;
	protected T simulation;
	
	public Entity(T simulation) {
		this.simulation = simulation;
		this.scheduler = simulation.getScheduler();
	}
	
	public void sendEvent(Event event) {scheduler.addEvent(event);}
	public void setScheduler(Scheduler scheduler) {this.scheduler = scheduler;}
	public Scheduler getScheduler() {return scheduler;}
	public T getSimulation() {return simulation;}
	
}
