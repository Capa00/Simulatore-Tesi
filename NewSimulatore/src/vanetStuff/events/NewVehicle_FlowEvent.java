package vanetStuff.events;

import simulator.Event;
import simulator.EventHandler;
import simulatorVanet.VanetSimulation;
import vanetStuff.VehicularFlow;
import vanetStuff.entities.Vehicle;

public class NewVehicle_FlowEvent extends Event {
	private VehicularFlow flow;
	private int veicoliCreati = 0;
	
	public NewVehicle_FlowEvent(VanetSimulation vanetSimulation, double amongManyMillisec, VehicularFlow flow) {
		super(EventName.NEW_FLOW_VEHICLE, amongManyMillisec);
		this.flow = flow;
	}

	/* (non-Javadoc)
	 * @see simulator.Event#getEventHandler()
	 */
	@Override
	public EventHandler getEventHandler() {
		return new NewVehicle_FlowEventHandler();
	}
	
	private static class NewVehicle_FlowEventHandler implements EventHandler {
		/* (non-Javadoc)
		 * @see simulator.EventHandler#handle(simulator.Event)
		 */
		@Override
		public <T extends Event> void handle(T event) {
			NewVehicle_FlowEvent flowEvent = (NewVehicle_FlowEvent)event;
			
			VehicularFlow flow = flowEvent.flow;
			VanetSimulation simulation = flow.getSimulation();
			
			int veicoliCreati = flowEvent.veicoliCreati;
			Vehicle v = new Vehicle(simulation, flow.getId()+"["+veicoliCreati+"]");
			
			v.setStartPoint(flow.getStartingPoint());
			v.setTargetPoint(flow.getTargetPoint());
			
			flow.sendEvent(new NewMobileNodeEvent(0, v));
			
			if(++flowEvent.veicoliCreati == flow.getVehicleNumber())return;
			/*debug*/
			System.out.println("\tho creato il veicolo "+v+", invio l'evento");
			/**/

			flow.sendEvent(flowEvent);			
		}
		
	}

}
