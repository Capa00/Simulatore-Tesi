package vanetStuff.roadNetworks;

public class Road {
	
	private Intersection source, target;
	private String id;
	
	private int index;
	
	private double length;
	private double maxVelocity;
	
	private static int progressiveIndex = 0;

	
	// COSTR //////////////////////////
	public Road(String id, Intersection source, Intersection target, double length, double maxVelocity) {
		this(source, target, length, maxVelocity);
		this.id = id;
	}

	public Road(Intersection source, Intersection target, double length, double maxVelocity) {
		super();
		this.source = source;
		this.target = target;
		this.length = length;
		this.maxVelocity = maxVelocity;
		
		source.addNeighourCrossRoad(target);
		
		id = source + "~" + target;
		index = progressiveIndex++;
	
	}

	
	// GETTERS //////////////////////
	
	public int getIndex() {return index;}
	public String getId() { return id; }
	
	public Intersection getSourceIntersection() { return source; }
	public Intersection getTargetIntersection() { return target; }

	public double getLength() { return length; }
	public double getMaxVelocity() { return maxVelocity; }
	
	
	// STATIC METHODS /////////////////////
	
	public static double euclidianDistance(Intersection intersectionA, Intersection intersectionB) {
		double x = Math.abs(intersectionA.getX() - intersectionB.getX());
		double y = Math.abs(intersectionA.getY() - intersectionB.getY());
		return Math.sqrt(x*x + y*y);
	}
}
