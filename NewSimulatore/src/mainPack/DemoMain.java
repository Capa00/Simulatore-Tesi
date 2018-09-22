package mainPack;

import simulatorVanet.VanetParameter;
import simulatorVanet.VanetScenario;
import simulatorVanet.VanetSimulation;
import vanetStuff.VehicularFlow;
import vanetStuff.roadNetworks.RoadNetwork;
import vanetStuff.roadNetworks.RoadNetworkFactory;

public class DemoMain {
	public static void main(String[] args) {
		VanetParameter parametri = new VanetParameter();
		parametri.setTempoDiSimulazione(-1);
		
		
		VanetScenario scenario = new VanetScenario();
		
		RoadNetwork rn = RoadNetworkFactory.get("crocevia");
		scenario.setRoadNetword(rn);

		VanetSimulation sim = new VanetSimulation(parametri, scenario);

		scenario.addFlow(new VehicularFlow(sim, 1, 500, rn.getIntersection("A"), rn.getIntersection("B"), 2));
//		scenario.addFlow(new VehicularFlow(sim, 1, 500, rn.getIntersection("B"), rn.getIntersection("C"), 20));
//		scenario.addFlow(new VehicularFlow(sim, 1, 500, rn.getIntersection("C"), rn.getIntersection("D"), 20));
//		scenario.addFlow(new VehicularFlow(sim, 1, 500, rn.getIntersection("D"), rn.getIntersection("A"), 20));
		
		sim.start();
	}
}
