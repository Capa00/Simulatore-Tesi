package simulatorVanet.history;

import java.io.Serializable;

public abstract class SpriteData implements Comparable<SpriteData>, Serializable{
	private static final long serialVersionUID = 605615498658870138L;

	protected double time;		
	public double getTime() {return time;} 		
	public void setTime(double time) {this.time = time;}

	
	
	public SpriteData() {}
	public SpriteData(double time) {this.time = time;}
	
	public int compareTo(SpriteData other) {
		double param = time - other.time;
		if(param > 0)return 1;
		if(param < 0)return -1;
		return 0;
	}
	
	
	public static class SpriteDataCar extends SpriteData {
		private static final long serialVersionUID = -6794179971698898879L;

		private String edge; 			public String getEdge() {return edge;}
		private double position;		public double getPosition() {return position;}
		
		public SpriteDataCar(String edge, double relativePosition) {
			this.edge = edge;
			position = relativePosition;
		}
	}
	
}
