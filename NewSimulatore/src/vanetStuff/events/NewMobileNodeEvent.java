package vanetStuff.events;

import simulator.Event;
import simulator.EventHandler;
import vanetStuff.entities.MobileNode;
import vanetStuff.roadNetworks.RoadNetwork;

public class NewMobileNodeEvent extends Event{
	private MobileNode mobileNode;
	
	public NewMobileNodeEvent(double amongManyMillisec, MobileNode mobileNode) {
		super(EventName.NEW_MOBILE_NODE, amongManyMillisec);
		this.mobileNode = mobileNode;
	}
	
	public MobileNode getMobileNode() {return mobileNode;}

	/* (non-Javadoc)
	 * @see simulator.Event#getEventHandler()
	 */
	@Override
	public EventHandler getEventHandler() {
		return new NewMobileNodeEventHandler();
	}
	
	
	// HANDLER //////////////////////////////
	
	private static class NewMobileNodeEventHandler implements EventHandler {

		/* (non-Javadoc)
		 * @see simulator.EventHandler#handle(simulator.Event)
		 */
		@Override
		public <T extends Event> void handle(T event) {
			MobileNode mobileNode = ((NewMobileNodeEvent)event).getMobileNode();
			RoadNetwork graph = mobileNode.getSimulation().getScenario().getRoadNetwork();
			graph.addMobileNode(mobileNode);			
		}
		
	}

}
