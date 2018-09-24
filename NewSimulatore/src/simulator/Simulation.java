package simulator;

import java.util.Random;

public abstract class Simulation <Param extends Parameter, Scen extends Scenario> extends Thread{
	protected Scheduler scheduler;

	protected Random random;
	protected Param parametri;
	protected Scen scenario;
	
	protected EventManager eventManager = new EventManager();
	
	// COSTR //////////////////////////
	
	public Simulation(Param parametri, Scen scenario) {
		this.parametri = parametri;
		this.scenario = scenario;
		
		Long seed = parametri.getSeed();
		if(seed != null) {random = new Random(parametri.getSeed());}
		else {random = new Random();}
		
		scheduler = new Scheduler(parametri.getTempoDiSimulazione());
		
	}
	
	// GETTER //////////////////////////
	
	public Scen getScenario() {return scenario;}
	public Param getParameter() {return parametri;}
	public Scheduler getScheduler() {return scheduler;}
	
	public EventManager getEventManager() {return eventManager;}
	
	// METHODS ////////////////////////
	
	public abstract void init();

	public void addEvent(Event evento) {
		scheduler.addEvent(evento);
	}
	
	@Override
	public void run() {
		try {
			init();
			scheduler.start();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
