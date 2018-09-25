package vanetStuff.events;

import simulator.Event;
import simulator.EventHandler;
import simulator.Scheduler;
import simulatorVanet.VanetSimulation;
import simulatorVanet.history.HistoryRecorder;
import vanetStuff.entities.MobileNode;
import vanetStuff.mobilities.MobilityManager;
import vanetStuff.roadNetworks.RoadNetwork;

public class UpdatePosition extends Event {
//	private HistoryRecorder historyRecorder;
	private RoadNetwork roadNetwork;
	private Scheduler scheduler;
	private MobilityManager mobilityManager;
	
	public UpdatePosition(VanetSimulation vanetSimulation, HistoryRecorder historyRecorder, double time) {
		
		super(EventName.UPDATE_POSITION, time);
		
//		this.historyRecorder = historyRecorder; //graphic update
		
		this.roadNetwork = vanetSimulation.getScenario().getRoadNetwork();
		this.scheduler  = vanetSimulation.getScheduler();
		this.mobilityManager = vanetSimulation.getParameter().mobilityManager;
		
	
	}
		

//	private SpriteData spriteData;


	/* (non-Javadoc)
	 * @see simulator.Event#getEventHandler()
	 */
	@Override
	public EventHandler getEventHandler() {
		return new UpdatePositionHandler();
	}
	
	private static class UpdatePositionHandler implements EventHandler {

		/* (non-Javadoc)
		 * @see simulator.EventHandler#handle(simulator.Event)
		 */
		@Override
		public <T extends Event> void handle(T event) {
			UpdatePosition updateEvent = (UpdatePosition)event;
			RoadNetwork roadNetwork = updateEvent.roadNetwork;
			MobilityManager mobilityManager = updateEvent.mobilityManager;
			
//			String idEntity = null;
			for(MobileNode m : roadNetwork.getMobilenodes()) {
//				idEntity = m.getId();
				mobilityManager.move(m);
				
				/*debug*/
				System.out.println("UpdatePosition.UpdatePositionHandler.handle():");
				/**/


				// GRAPHIC UPDATE
				//storia veicolo
//				spriteData = m.getSpriteData();
//				spriteData.setTime(scheduler.getCurrentTime());
//				historyRecorder.updatePosition(idEntity, spriteData);
				////////////////
				
				
				//creare una classe position updater per ogni tipo di nodo mobile per le regole di posizionamento
				//richiamare l'updater e muovere il nodo
			}
			
			updateEvent.scheduler.addEvent(updateEvent);
					
		}
		
	}

}
