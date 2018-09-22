package vanetStuff.roadNetworks;
import java.util.HashMap;
import java.util.LinkedList;

import vanetStuff.entities.MobileNode;

public class RoadNetwork {
	private String id;

	private HashMap <String, Intersection> incroci = new HashMap<>(); //<id , intersection>
	private HashMap <String, Road> 		   strade = new HashMap<>(); //<id , road>
	
	private LinkedList<MobileNode> nodiMobili = new LinkedList<>();

	// COSTR ////////////////////////////
	
	public RoadNetwork(String id) {this.id = id;}
	
	
	// GETTERS ////////////////////////////

	public HashMap <String, Intersection> getIntersections() { return incroci; }
	public HashMap <String, Road>  		  getRoads() { return strade; }
	
	public String getId() { return id; }
	
	public Road						getRoad (String roadId) {return strade.get(roadId);}
	public Intersection 			getIntersection (String intersectionId) {return incroci.get(intersectionId);}
	public LinkedList<MobileNode> 	getMobilenodes(){return nodiMobili;}
	
	// METHODS //////////////////////////
	
	public void addIntersection(Intersection intersection) { 
		if(incroci.get(intersection.getId()) != null) 
			throw new IllegalArgumentException("the intersection "+intersection.getId()+" is already in the road network");
		
		incroci.put(intersection.getId(), intersection); 
		
	}
	
	public Intersection addIntersection(String intersectionId, double x, double y) {
		if(incroci.get(intersectionId) != null) 
			throw new IllegalArgumentException("the intersection "+intersectionId+" is already in the road network");

		Intersection intersection = new Intersection(intersectionId);
		intersection.setXY(x, y);
		
		return intersection;
	}
	
	private void catchRoadException(String roadId, String sourceId, String targetId) {
		//se la strada già esiste (???)
		if(strade.get(roadId) != null) 
			throw new IllegalArgumentException("the road "+roadId+" is already in the road network");
		//se non esiste il source
		if(incroci.get(sourceId) == null) 
			throw new IllegalArgumentException("the source node "+sourceId+" does not exist");
		//se non esiste il target
		if(incroci.get(targetId) == null)
			throw new IllegalArgumentException("the target node "+targetId+" does not exist");
	
	}
	
	public Road addRoad(String roadId, String sourceId, String targetId, double length, double maxVelocity) {
		catchRoadException(roadId, sourceId, targetId);
		
		Intersection source = incroci.get(sourceId);
		Intersection target = incroci.get(targetId);
				
		Road road = new Road(roadId, source, target, length, maxVelocity);
		strade.put(roadId, road);
		
		return road;
		
	}

	public void addRoad(Road road) {
		Intersection source = road.getSourceIntersection();
		Intersection target = road.getTargetIntersection();
		
		catchRoadException(road.getId(), source.getId(), target.getId());
		
		strade.put(road.getId(), road); 
		
	}
	
	public void addMobileNode(MobileNode mobileNode) {
		nodiMobili.add(mobileNode);
	}

}
