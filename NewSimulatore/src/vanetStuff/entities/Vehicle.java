package vanetStuff.entities;

import simulatorVanet.VanetSimulation;
import simulatorVanet.history.SpriteData;
import simulatorVanet.history.SpriteData.SpriteDataCar;
import util.RoadPath;
import vanetStuff.mobilities.VehicleMobilityHandler;
import vanetStuff.mobilities.MobilityHandler;
import vanetStuff.roadNetworks.Intersection;
import vanetStuff.roadNetworks.Road;
import vanetStuff.roadNetworks.RoadNetwork;

public class Vehicle extends MobileNode {
	private boolean onTheRoad = false;
	private Intersection start, target; //nodo di partenza e di arrivo
	private RoadNetwork grafo; //rete stradale
	/////////////////////////////
	private Intersection lastIntersection; //ultima intersezione attraversata
	private Road 		 currentRoad; //strada che sta percorrendo il veicolo
	private double 		 currentPositionOnRoad; //posizione attuale sull'arco
	private double 		 roadLength; //lunghezza della strada
	////////////////////////////
	private RoadPath currentPath; //strade completamente percorse fino a questo momento
	
	
	public Vehicle(VanetSimulation simulation, String id) {
		super("vehicle", simulation,id);
		grafo = simulation.getScenario().getRoadNetwork();
		
		currentPath = new RoadPath();
	}

	
	// GETTERS ///////////////////////
	
	public Intersection getStart() {return start;}
	public Intersection getTarget() {return target;}
	public Intersection getLastIntersection() {return lastIntersection;}
	public RoadPath		getRoadPath() {return currentPath;}
	public Road			getCurrentRoad() {return currentRoad;}
	public RoadNetwork	getRoadNetwork() {return grafo;}
	public double		getCurrentPositionOnTheRoad() {return currentPositionOnRoad;}
	public double		getRoadLength() {return roadLength;}
	
//	@Override
//	public SpriteData getSpriteData() {
//		if(!onTheRoad)return null;
//		return new SpriteDataCar(currentRoad.getId(), currentPositionOnRoad/roadLength);
//	}

	
	// SETTERS ///////////////////////////
	
	public void setStartPoint			(Intersection start) {this.start = start;}
	public void setTargetPoint			(Intersection target) {this.target = target;}
	public void setLastIntersection (Intersection lastIntersection) {this.lastIntersection = lastIntersection;}
	
	public void setCurrentRoad (Road road) {
		this.currentRoad = road;
		roadLength = currentRoad.getLength();
	}


	// OVERRIDES //////////////////////////
	
	@Override
	public MobilityHandler getMobilityHandler() {return new VehicleMobilityHandler();}

}
