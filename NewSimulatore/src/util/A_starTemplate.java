package util;

import java.util.LinkedList;
import java.util.List;

public abstract class A_starTemplate <Graph, Node, Edge>{
	
	public List<Node> resolve(Graph graph, Node start, Node goal) {
		
		LinkedList<Node> closedSet = new LinkedList<>();
		LinkedList<Node> openSet   = new LinkedList<>();
		
		openSet.add(start);
		
		List<Node> nodi   = getNodesList(graph);
		double[] g_score  = new double[nodi.size()];
		double[] f_score  = new double[nodi.size()];
		int   [] cameFrom = new int[nodi.size()];
		
		for (int i = 0; i < g_score.length; i++) {
			g_score[i] = Double.POSITIVE_INFINITY;
			f_score[i] = Double.POSITIVE_INFINITY;
		}
		
		g_score[getNodeIndex(start)] = 0;
		f_score[getNodeIndex(start)] = getEuristicCostBetween(start, goal);
		
		Node current = null;
		int currentIndex;
		int neighbourIndex;
		double tentative_gScore;
		while(!openSet.isEmpty()) {
			currentIndex = getIndiceCostoMinimo(f_score);
			current = getNodeFromIndex(currentIndex);

			if(current == goal) {
				return ricostruisciPercorso(cameFrom, currentIndex);
			}
			
			openSet.remove(current);
			closedSet.add(current);
			
			for(Node neighbour : getAdjacentNode(current)) {
				if(closedSet.contains(neighbour))continue;
			
				tentative_gScore = g_score[currentIndex] + getCostBetween(current, neighbour);
				neighbourIndex = getNodeIndex(neighbour);
				if(!openSet.contains(neighbour)) openSet.add(neighbour);
				
				else if (tentative_gScore >= g_score[neighbourIndex]) continue;
				
				cameFrom[neighbourIndex] = currentIndex;
				g_score[neighbourIndex] = tentative_gScore;
				f_score[neighbourIndex] = g_score[neighbourIndex] + getHeuristicCost(neighbour, goal);
			}
		}
		return new LinkedList<>();
		
	}
	
	private List<Node> ricostruisciPercorso(int[] pred, int currentNode) {
		LinkedList<Node> nodePath = new LinkedList<>();
		
		int u = currentNode;
		
		while(pred[u] != -1 ) {
			nodePath.addFirst(getNodeFromIndex(u));
			u = pred[u];
		}
		return nodePath;

	}
	
	private int getIndiceCostoMinimo(double[] score) {
		int minI = 0;
		double minScore = score[0];
		for (int i = 0; i < score.length; i++) {
			if(score[0] < minScore) {
				minI = i;
				minScore = score[0];
			}
		}
		
		return minI;
	}
	
	
	
	
	protected abstract List<Node> getAdjacentNode(Node node);
	protected abstract List<Node> getNodesList(Graph graph);
	protected abstract int getNodeIndex(Node node);
	protected abstract double getEuristicCostBetween(Node node1, Node node2);
	protected abstract Node getNodeFromIndex(int nodeIndex);
	protected abstract double getCostBetween(Node node1, Node node2);
	protected abstract double getHeuristicCost(Node node1, Node node2);
}
