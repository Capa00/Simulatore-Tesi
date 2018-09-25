package simulatorVanet;

import simulator.Parameter;
import vanetStuff.mobilities.MobilityManager;

public class VanetParameter extends Parameter {
	// GRAPHIC PARAMETER //
	public double distanceFromEdge = -6;

	// MOBILITY PARAMETER //
	public MobilityManager mobilityManager = new MobilityManager();
	
	
	// SETTERS /////////////////////////
 	public VanetParameter setDistanceFromEdge(double distance) {distanceFromEdge = distance;return this;}
	
}
