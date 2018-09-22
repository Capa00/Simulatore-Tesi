package vanetStuff.roadNetworks;

public class RoadNetworkFactory {
	
	private static final String
	CROCEVIA = "crocevia";
	
	
	public static RoadNetwork get(String id) {
		RoadNetwork rn = new RoadNetwork(id);
		
		switch(id) {
		case CROCEVIA:
			Intersection A = new Intersection("A"); A.setXY(  0 , -20);
			Intersection B = new Intersection("B"); B.setXY( 20 , 0  );
			Intersection C = new Intersection("C"); C.setXY(  0 , 20 );
			Intersection D = new Intersection("D"); D.setXY(-20 , 0  );
			Intersection O = new Intersection("O"); O.setXY(  0 , 0  );

			rn.addIntersection(A);
			rn.addIntersection(B);
			rn.addIntersection(C);
			rn.addIntersection(D);
			rn.addIntersection(O);
			
			Road r = new Road(A, O, Road.euclidianDistance(A, O), 50);
			rn.addRoad(r);
			r = new Road(B, O, Road.euclidianDistance(B, O), 50);
			rn.addRoad(r);
			r = new Road(C, O, Road.euclidianDistance(C, O), 50);
			rn.addRoad(r);
			r = new Road(D, O, Road.euclidianDistance(D, O), 50);
			rn.addRoad(r);
			break;
			
		default: throw new IllegalArgumentException("RoadNetwork "+id+" does not exist"); 
		}
		
		return rn;
	}
}
