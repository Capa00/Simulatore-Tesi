package vanetStuff.roadNetworks;

import java.util.LinkedList;

public class Intersection implements Comparable<Intersection>{
	private static int progressiveIndex = 0;

	
	private LinkedList<Intersection> incrociAdiacenti = new LinkedList<>();
	private String id;
	private int index;
	
	private double x,y;
	
	
	// COSTR //////////////////////////////
	
	public Intersection() { 
		index = progressiveIndex;
		id = ""+progressiveIndex++;
	
	}
	
	public Intersection(String id) {
		index = progressiveIndex++;
		this.id = id; 
		
	}
	
	
	// GETTERS /////////////////////////////
	
	public int getIndex() {return index;}
	public String getId() { return id; }
	public double getX() {return x;}
	public double getY() {return y;}
	public LinkedList<Intersection> getAdjacentIntersections() { return incrociAdiacenti; }
	
	
	// SETTERS ////////////////////////////
	
	public Intersection setX(double x) {this.x = x; return this;}
	public Intersection setY(double y) {this.y = y; return this;}
	public Intersection setXY(double x, double y) {
		this.x = x; 
		this.y = y;
		return this;
		
	}
	
	// METHODS ////////////////////////////
	
	public void addNeighourCrossRoad(Intersection neighbor) {
		incrociAdiacenti.add(neighbor);
	
	}


	// OVERRIDES //////////////////////////
	
	@Override
	public int compareTo(Intersection arg0) { return index - arg0.index; }
	
	
}
