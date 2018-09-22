package util;

import java.util.LinkedList;

import vanetStuff.roadNetworks.Road;

public class RoadPath {
	
	private LinkedList<Road> path = new LinkedList<>();
	private double cost;
	
	public void addRoad(Road road) {
		path.add(road);
		cost += road.getLength(); 
	}
	
	
	public LinkedList<Road> getRoadList(){return path;}
	public double getTotalCost() {return cost;}
	
}
