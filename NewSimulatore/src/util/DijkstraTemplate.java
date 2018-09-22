package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class DijkstraTemplate<Graph, Edge, Node> {
	
	
	// METHODS //////////////////////////////
	
	public HashMap<Node, Node> getSpanningTree(Graph graph, Node source) {
		int pred[] = spanningTree(graph, source);
		HashMap<Node, Node> spanningTree = new HashMap<>();
		
		for (int i = 0; i < pred.length; i++) {
			spanningTree.put(getNodeFromId(i), getNodeFromId(pred[i]));
		}
		
		return spanningTree;
	
	}
	
	
	
	public List<Node> getNodeMinPath(Graph graph, Node source, Node destination){
		LinkedList<Node> nodePath = new LinkedList<>();
		
		int[] pred = spanningTree(graph, source);
		
		int u = getNodeId(destination);
		
		while(pred[u] != -1 ) {
			nodePath.addFirst(getNodeFromId(u));
			u = pred[u];
		}
		
		return nodePath;
	
	}
	
	
	
	public List<Edge> getEdgeMinPath(Graph graph, Node source, Node destination){
		LinkedList<Node> nodePath = new LinkedList<>();
		
		int[] pred = spanningTree(graph, source);
		
		int u = getNodeId(destination);
		
		while(pred[u] != -1 ) {
			nodePath.addFirst(getNodeFromId(u));
			u = pred[u];
		}
		
		return convertToEdgePath(nodePath);
	
	}
	
	
	
	
	public List<Edge> convertToEdgePath(List<Node> nodePath){
		LinkedList<Edge> edgePath = new LinkedList<>();

		if(nodePath.size() == 0)return edgePath;
		
		Iterator<Node> it = nodePath.iterator();
		Node previous = it.next();
		Node next = null;
		while(it.hasNext()) {
			next = it.next();
			edgePath.addLast(getEdgeBetweenNode(previous, next));
			previous = next;
		}
		
		return edgePath;
	
	}
	
	
	
	public List<Node> convertToNodePath(List<Edge> edgePath){
		LinkedList<Node> nodePath = new LinkedList<>();
		
		if(edgePath.size() == 0)return nodePath;
		
		nodePath.addLast(getSourceNodeOfEdge(edgePath.get(0)));
		for (Edge edge : edgePath) {
			nodePath.addLast(getTargetNodeOfEdge(edge));
		}
		
		return nodePath;
		
	}
		
	
	// SUPPORT METHODS //////////////////////////////////
	
	private int[] spanningTree(Graph graph, Node source) {
		List<Node> Q = getNodeList(graph);
		
		double dist[] = new double[Q.size()];
		int pred[] = new int[Q.size()];
		
		for(Node n : Q) { dist[getNodeId(n)] = Double.POSITIVE_INFINITY; }
		for (int i = 0; i < pred.length; i++) { pred[i] = -1; }
		dist[getNodeId(source)] = 0;
		
		Node u = source;
		List<Node> neighbour = null;
		double alt;
		while(!Q.isEmpty()) {
			Q.remove(u);
			
			if(dist[getNodeId(u)] == Double.POSITIVE_INFINITY)break;
			
			neighbour = getNeighbourList(u);
			for (Node v : neighbour) {
				if(!Q.contains(v))continue;
				
				alt = dist[getNodeId(u)] + distanceBetween(u, v);
				if(alt < dist[getNodeId(v)]) {
					dist[getNodeId(v)] = alt;
					pred[getNodeId(v)] = getNodeId(u);
				}
			}
			
			u = Q.get(trovaMin(dist));
		}
		
		return pred;
	
	}
	
	
	private int trovaMin(double[] dist) {
		int indexMin = 0;
		double minVal = dist[0];
		for (int i = 1; i < dist.length; i++) {
			if( dist[i] < minVal ) {
				indexMin = i;
				minVal = dist[i];
			}
		}
		return indexMin;

	}

	
	// ABSTRACTS //////////////////////////////
	
	protected abstract List<Node> getNodeList(Graph graph);
	protected abstract List<Node> getNeighbourList(Node node);
	protected abstract Edge getEdgeBetweenNode(Node node1, Node node2);
	protected abstract Node getNodeFromId(int id);
	protected abstract Node getTargetNodeOfEdge(Edge edge);
	protected abstract Node getSourceNodeOfEdge(Edge edge);
	protected abstract int getNodeId(Node node);
	protected abstract double distanceBetween(Node node1, Node node2);
	
		
}
