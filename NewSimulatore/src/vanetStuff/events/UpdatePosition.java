package vanetStuff.events;

import simulator.Event;
import simulator.Scheduler;
import simulatorVanet.VanetSimulation;
import simulatorVanet.history.HistoryRecorder;
import simulatorVanet.history.SpriteData;
import vanetStuff.entities.MobileNode;
import vanetStuff.roadNetworks.RoadNetwork;

public class UpdatePosition extends Event {
	private HistoryRecorder historyRecorder;
	private RoadNetwork roadNetwork;
	private Scheduler scheduler;
	
	public UpdatePosition(VanetSimulation vanetSimulation, HistoryRecorder historyRecorder, double time) {
		
		super(Events.UPDATE_POSITION, time);
		this.historyRecorder = historyRecorder;
		
		this.roadNetwork = vanetSimulation.getScenario().getRoadNetwork();
		this.scheduler  = vanetSimulation.getScheduler();
		
	
	}
		

	private SpriteData spriteData;
	@Override
	public void action() {
		String idEntity = null;
		for(MobileNode m : roadNetwork.getMobilenodes()) {
			idEntity = m.getId();
			
			System.out.println("update "+idEntity);
			
			//storia veicolo
			spriteData = m.getSpriteData();
			spriteData.setTime(scheduler.getCurrentTime());
			historyRecorder.updatePosition(idEntity, spriteData);
			////////////////
			
			
			//creare una classe position updater per ogni tipo di nodo mobile per le regole di posizionamento
			//richiamare l'updater e muovere il nodo
		}
		
		scheduler.addEvent(this);
	}

}
