package vanetStuff.entities;

import simulator.Entity;
import simulator.Event;
import simulatorVanet.VanetSimulation;
import simulatorVanet.history.SpriteData;
import vanetStuff.events.Events;
import vanetStuff.mobilities.MobilityHandler;
import vanetStuff.roadNetworks.RoadNetwork;

public abstract class MobileNode extends Entity{
	public final String clazz;
	private String id;
	private VanetSimulation simulation;
	private double x,y;
	
	
	// COSTR /////////////////////
	
	public MobileNode(String clazz, VanetSimulation simulation, String id) {
		super(simulation.getScheduler());
		this.simulation = simulation; 
		this.id = id; 
		this.clazz = clazz;
		
	}
	
	
	// SETTERS //////////////////
	
	public void setX(double x) {this.x = x;}
	public void setY(double y) {this.y = y;}
	
	// GETTERS //////////////////
	
	public String getId() { return id; }
	public double getX() { return x; }
	public double getY() { return y;}
	
	
	// METHODS //////////////////
	
	public void updateView() {
//		simulation.updateView(this);
	}

	public void handle(Event event) {
		switch(event.getName()) {
		case Events.NEW_MOBILE_NODE: 
			/*1*///aggiunge nodo mobile alla strada
			RoadNetwork graph = simulation.getScenario().getRoadNetwork();
			graph.addMobileNode(this);
			break;
		}
		//qui si fa l'update position TODO
		//handler.handle(event);
	}
	
	// ABSTRACT //////////////////
	public abstract SpriteData getSpriteData();
	//restituisce l'oggetto che gestisce la sua mobilità
	public abstract MobilityHandler getMobilityHandler();
	
}
