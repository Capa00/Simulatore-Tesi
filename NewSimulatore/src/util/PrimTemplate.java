package util;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public abstract class PrimTemplate<Graph, Node> {
	private static class Element<T> implements Comparable<Element<T>>{
		public T node;
		public double priority;
		
		@Override
		public int compareTo(Element<T> e) {
			double param = priority - e.priority;
			if ( param < 0 ) return -1;
			return 1;
		}
		@SuppressWarnings("unchecked")
		public boolean equals(Object o) {
			Element<T> e = (Element<T>) o;
			return node == e.node;
		}
	}
	
	public HashMap<Node,Node> resolve(Graph graph, Node node) {
		List<Node> nodeList = getNodeList(graph);
		Element<Node> e = null;
		HashMap<Node, Node> pred = new HashMap<>();
		PriorityQueue<Element<Node>> Q = new PriorityQueue<>();
		
		for (Node n : nodeList) {
			e = new Element<>();
			e.node = n;
			if(e.node != node) e.priority = Double.POSITIVE_INFINITY;
			else e.priority = 0;
			Q.add(e);
		}
		
		Element<Node> u = null;
		double costBetween = 0;
		while(!Q.isEmpty()) {
			u = Q.remove();
			for(Node v : getAdjacentNodes(u.node)) {
				costBetween = costBetween(u.node, v);
				if(Q.contains(v) && (costBetween < u.priority)) {
					pred.put(v, u.node);
					e = new Element<>(); e.node = v;
					Q.remove(e);
					e.priority = costBetween;
					Q.add(e);
				}
			}
		}
		
		return pred;
		
		
	}
	
	protected abstract double costBetween(Node node1, Node node2); 
	protected abstract List<Node> getAdjacentNodes(Node node);
	protected abstract List<Node> getNodeList(Graph graph);
	protected abstract int getNodeIndex(Node node);
}
