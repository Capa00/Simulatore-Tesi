package simulatorVanet;

import java.io.File;

import simulator.Simulation;
import simulatorVanet.history.HistoryRecorder;
import vanetStuff.VehicularFlow;
import vanetStuff.events.NewVehicle_FlowEvent;
import vanetStuff.events.UpdatePosition;

public class VanetSimulation extends Simulation<VanetParameter, VanetScenario>{
	private HistoryRecorder history;
	
	public VanetSimulation(VanetParameter parametri, VanetScenario scenario) {
		super(parametri, scenario);
	}
	
	
	public HistoryRecorder getHistoryRecorder() {return history;}
	@Override
	public void init() {
		
		//aggiungo i flussi
		for (VehicularFlow flow : scenario.getFlows()) {
			addEvent(new NewVehicle_FlowEvent(this, flow.getStartTime(), flow)); 
		}
		
		String s = File.separator;
		history = new HistoryRecorder(10000, "C:"+s+"workspace JAVA"+s+"NewSimulatore"+s+"data");

		addEvent(new UpdatePosition(this, history, 1));		
	
	}

}
