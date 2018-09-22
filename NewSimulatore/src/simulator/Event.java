package simulator;

public abstract class Event implements Comparable<Event>{
	//name of the event
	private String name = null;
	
	//tra quanti millisecondi parte l'evento
	private Double time = null;
	
	/////////////////////////////////////////////////
	
	public Event(String eventName, double amongManyMillisec) {
		name = eventName;
		time = amongManyMillisec;

	}
	//////////////////////////////////////////////
	
	//azione da compiere dopo l'evento
	public abstract void action();
	
	//set shift time
	public void setTime(double time_){time = time_;}
	
	public double getTime(){return time;}
	
	public String getName(){return name;}
	
	@Override
	public int compareTo(Event event) {
		double res = time - event.time;
		if (res <= 0) return -1;
		return 1;
	}
	@Override
	public String toString() {return "Event["+name+"]";}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Event) {
			return name.equals((((Event)o).name));
		}
		return false;
	}
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
}
