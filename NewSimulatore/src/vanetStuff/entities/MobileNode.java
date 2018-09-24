package vanetStuff.entities;

import simulator.Entity;
import simulator.Event;
import simulator.EventHandler;
import simulatorVanet.VanetSimulation;
import simulatorVanet.history.SpriteData;
import vanetStuff.events.EventName;
import vanetStuff.mobilities.MobilityHandler;
import vanetStuff.roadNetworks.RoadNetwork;

public abstract class MobileNode extends Entity{
	public final String clazz;
	private String id;
	private double x,y;
	
	
	// COSTR /////////////////////
	
	public MobileNode(String clazz, VanetSimulation simulation, String id) {
		super(simulation);
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
	public VanetSimulation getSimulation() {return (VanetSimulation)simulation;}
	
	
	// METHODS //////////////////
	
	public void updateView() {
//		simulation.updateView(this);
	}

	public void handle(Event event) {
		/*debug*/
		System.out.println("MobileNode.handle(): "+this);
		/**/
		simulation.getEventManager().handle(this, event);

	}
	
	// ABSTRACT //////////////////
	public abstract SpriteData getSpriteData();
	//restituisce l'oggetto che gestisce la sua mobilità
	public abstract MobilityHandler getMobilityHandler();
	
	
	protected abstract static class MobileNodeEventHandler<T extends MobileNode> implements EventHandler<T> {

		/* (non-Javadoc)
		 * @see vanetStuff.EventHandler#handle(simulator.Event)
		 */
		@Override
		public void handle(T mobileNode, Event event) {
			/*debug*/
			System.out.println("MobileNode.MobileNodeEventHandler.handle(): "+event.getName());
			/**/

			switch(event.getName()) {
			
			case EventName.NEW_MOBILE_NODE:
				/*1*///aggiunge nodo mobile alla strada
				RoadNetwork graph = mobileNode.getSimulation().getScenario().getRoadNetwork();
				graph.addMobileNode(mobileNode);
				
				/*debug*/
				System.out.println("\taggiunto nodo mobile "+mobileNode+" id="+mobileNode.getId()+" al grafo");
				/**/

				break;
			}
			
		}
		
	}
}
