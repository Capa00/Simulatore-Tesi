package graphDisplayer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;

import simulatorVanet.VanetSimulation;
import simulatorVanet.history.SpriteData;
import vanetStuff.roadNetworks.Road;
import vanetStuff.roadNetworks.RoadNetwork;

public class Present extends Thread{
	private MultiGraph graph;
	private RoadNetwork roadNetwork;
	
	private Future futuro;
	
	private Updater updater;

	private HashMap<Sprite, SpriteData> entitaVive;

	
	// COSTR ///////////////////
	
	public Present(VanetSimulation vanetSimulation, Destiny destino) {
		roadNetwork = vanetSimulation.getScenario().getRoadNetwork();
		graph = new MultiGraph(roadNetwork.getId());
		
		updater = new Updater();
		
		entitaVive = new HashMap<>();
		
		for (String id : roadNetwork.getIntersections().keySet()) {
			
			graph.addNode(id);
		
		}
		
		String id, source, target;
		for (Road road : roadNetwork.getRoads().values()) {
		
			id = road.getId();
			source = road.getSourceIntersection().getId();
			target = road.getTargetIntersection().getId();

			graph.addEdge(id, source, target);
		
		}
		
		
		SpriteManager spriteManager = new SpriteManager(graph);
		futuro = new Future(spriteManager, destino, vanetSimulation);
		
	}
	
	
	public void run() {
		double time = -1;
		
		Sprite sprite;
		SpriteData spriteData;
		
		LinkedList<Sprite> removeList = new LinkedList<>();

		while(true) { //TODO
			
			time++;
			futuro.updatePresent(time);
			
			for (Entry<Sprite, SpriteData> e : entitaVive.entrySet()) {
				spriteData = e.getValue();
				sprite = e.getKey();
				
				if(spriteData == null) {
					removeList.add(e.getKey());
					continue;
				}
				
				updater.update(sprite, spriteData);
			}
			
			for (Sprite s : removeList) {
				entitaVive.remove(s);
			}
			removeList.clear();
		}
		
		
	}
	
	
	
}
