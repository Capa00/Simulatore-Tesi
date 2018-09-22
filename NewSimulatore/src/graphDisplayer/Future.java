package graphDisplayer;

import java.util.ArrayList;

import org.graphstream.ui.spriteManager.SpriteManager;

import simulatorVanet.VanetSimulation;
import simulatorVanet.history.Story;

public class Future {
	private SpriteManager spriteManager;
	
	private Destiny destino;
	private ArrayList<Story> stories;
	private VanetSimulation simulazione;
	
	private double currentTime;
	
	public Future(SpriteManager spriteManager, Destiny destiny, VanetSimulation simulation) {
		
		this.spriteManager = spriteManager;
		this.destino = destiny;
		this.simulazione = simulation;
		
	}
	
	public Future(Present present, Destiny destiny) {
		
	}
	
	public void updatePresent(double time){
		currentTime = time;
		
	}
	
	
}
