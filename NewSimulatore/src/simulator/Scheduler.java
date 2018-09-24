package simulator;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Scheduler {
	@SuppressWarnings("unused")
	private static final int MAX_TIMEHORIZON_24DAY = Integer.MAX_VALUE;
	private static String realTimeEvent = "R~T";

	private boolean start = false;
	private boolean realTime = false;

	private long stopTime;
	
	private double 
	timeHorizon = 0,
	currentTime = 0;
	
	private PriorityQueue<Event> queue = new PriorityQueue<>();
	private LinkedList<Event> story = new LinkedList<>();
	
	
	// COSTR //////////////////////////////////////////
	
	public Scheduler(){}
	
	public Scheduler(double timeHorizonMillisec){
		timeHorizon = timeHorizonMillisec;
	}
	
	public Scheduler(double timeHorizonMillisec, boolean realtime, long stoptime) {
		this(timeHorizonMillisec);
		realTime = realtime;
		stopTime = stoptime;
	}
	
	
	// GETTER //////////////////////////////////////////
	
	public PriorityQueue<Event> getEventQueue(){return queue;}
	public LinkedList<Event> getStoryQueue(){return story;}
	public double getCurrentTime(){return currentTime;}

	
	// SETTER ////////////////////////////////
	
	public void resetRealTime() { realTime = false; }
	public void setRealTime(long stopTime) {
		this.realTime = true;
		this.stopTime = stopTime;
	}
	
	
	// METHODS ////////////////////////////////////
	
	public void reset() {
		queue.clear();
		story.clear();
		currentTime = 0;
	}
	
	public void addEvent(Event event){
		event.setTime(currentTime + event.getTime());
		queue.add(event);
		
	}
	
	
	/////////////////
	public void stopSimulation(){
		start = false;
		queue.clear();
		
	}

	
	//////////////////
	public void start() throws InterruptedException{
		start = true;
		Event event = null;
		
		if(realTime) {addEvent(new RealTime(stopTime));}
		
		while(start){
			if(queue.size()>0){
				//get next event
				event = queue.remove();

				//refresh current time
				currentTime = event.getTime();
				
				//action on the event
				event.action();
				
				//stop simulation if time horizon is end
				if(timeHorizon > 0 && currentTime>timeHorizon){
					start = false;
				}
				
			}

		}
		
	}
	
	private class RealTime extends Event {
		private long stopTime;
		public RealTime(long stopTime) {
			super(realTimeEvent, 1);
			this.stopTime = stopTime;
		}

		@Override
		public void action() {
			try {
				Thread.sleep(stopTime);
				addEvent(new RealTime(stopTime));
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
	
	/////////////////////// TODO ///////////////////////////////
	
	@Deprecated
	public void pause(){/*pause = true;*/}
	@Deprecated
	public void restart(){/*pause = false;*/}
	
	
}
