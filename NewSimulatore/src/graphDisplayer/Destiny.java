package graphDisplayer;

import simulatorVanet.VanetSimulation;
import simulatorVanet.history.HistoryRecorder;

public class Destiny {
	private HistoryRecorder stories;
	VanetSimulation simulation;
	
	public Destiny(VanetSimulation simulation, HistoryRecorder historyRecorder) {
		stories = historyRecorder;
		
	}
}
