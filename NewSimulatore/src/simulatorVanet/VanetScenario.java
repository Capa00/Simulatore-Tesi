package simulatorVanet;

import java.util.LinkedList;

import simulator.Scenario;
import vanetStuff.VehicularFlow;
import vanetStuff.roadNetworks.RoadNetwork;

public class VanetScenario implements Scenario {
	private RoadNetwork grafo;
	private LinkedList<VehicularFlow> flussi = new LinkedList<>();
	
	
	public VanetScenario addFlow(VehicularFlow flow) {flussi.add(flow); return this;}
	
	public VanetScenario setRoadNetword(RoadNetwork roadNetwork) {grafo = roadNetwork; return this;}

	public RoadNetwork getRoadNetwork() {return grafo;}
	public LinkedList<VehicularFlow> getFlows() {return flussi;}
	
	

}
