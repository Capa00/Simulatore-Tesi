package simulatorVanet;

import simulator.Parameter;

public class VanetParameter extends Parameter {
	// GRAPHIC PARAMETER //
	public double distanceFromEdge = -6;
	
	
	// SETTERS /////////////////////////
	
	public VanetParameter setDistanceFromEdge(double distance) {distanceFromEdge = distance;return this;}
}
