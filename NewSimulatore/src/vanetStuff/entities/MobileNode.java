package vanetStuff.entities;

import simulator.Entity;
import simulator.Event;
import simulator.EventHandler;
import simulatorVanet.VanetSimulation;
import vanetStuff.events.EventName;
import vanetStuff.events.NewMobileNodeEvent;
import vanetStuff.mobilities.MobilityHandler;
import vanetStuff.roadNetworks.RoadNetwork;

public abstract class MobileNode extends Entity<VanetSimulation>{
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


	// ABSTRACT //////////////////
//	public abstract SpriteData getSpriteData(); GRAPHIC DATA
	
	//restituisce l'oggetto che gestisce la sua mobilità
	public abstract MobilityHandler getMobilityHandler();
	
	
	protected abstract static class MobileNodeEventHandler implements EventHandler {

		/* (non-Javadoc)
		 * @see vanetStuff.EventHandler#handle(simulator.Event)
		 */
		@Override
		public void handle(Event event) {
			/*debug*/
			System.out.println("MobileNode.MobileNodeEventHandler.handle(): "+event.getName());
			/**/

			switch(event.getName()) {
			
			case EventName.NEW_MOBILE_NODE:
				/*1*///aggiunge nodo mobile alla strada
				MobileNode mobileNode = ((NewMobileNodeEvent)event).getMobileNode();
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
