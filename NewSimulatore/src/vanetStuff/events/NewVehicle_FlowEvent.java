package vanetStuff.events;

import simulator.Event;
import simulatorVanet.VanetSimulation;
import vanetStuff.VehicularFlow;
import vanetStuff.entities.Vehicle;

public class NewVehicle_FlowEvent extends Event {
	private VehicularFlow flow;
	private int veicoliCreati = 0;
	private VanetSimulation simulation;
	
	public NewVehicle_FlowEvent(VanetSimulation vanetSimulation, double amongManyMillisec, VehicularFlow flow) {
		super(EventName.NEW_FLOW_VEHICLE, amongManyMillisec);
		this.flow = flow;
		simulation = vanetSimulation;
	}

	@Override
	public void action() {
		/*debug*/
		System.out.println("NewVehicle_FlowEvent.action():");
		/**/

		Vehicle v = new Vehicle(simulation, flow.getId()+"["+veicoliCreati+"]");
		
		v.setStartPoint(flow.getStartingPoint());
		v.setTargetPoint(flow.getTargetPoint());
		
		flow.sendEvent(new NewMobileNodeEvent(0, v));
		
		if(++veicoliCreati == flow.getVehicleNumber())return;
		/*debug*/
		System.out.println("\tho creato il veicolo "+v+", invio l'evento");
		/**/

		flow.sendEvent(this);
	}

}
