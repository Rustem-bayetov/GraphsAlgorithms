package graphs;

import graphs.graph.*;

public class Graph_DFS {
	static Graph_DFS INSTANCE = new Graph_DFS();
	
	// Basic Depth First Search traversing algorithm
	public static void main(String[] args) {
		RGraph graph = GraphFactory.initGraph9();		
		graph.print();
		
		INSTANCE.DFS(graph);		
		graph.print();
	}

	public void DFS(RGraph G) {
		G.setUnexplored();
		for(Vertex v : G.vertices()) {
			if (v.getLabel() == VertexLabel.UNEXPLORED)
				DFS(G, v);
		}
	}
	
	public void DFS(RGraph G, Vertex v) {
		v.setLabel(VertexLabel.VISITED);
		
		for (Edge e : v.getIncidentEdges()) {
			if (e.getLabel() == EdgeLabel.UNEXPLORED) {
				Vertex w = G.opposite(v, e);
				if (w.getLabel() == VertexLabel.UNEXPLORED) {
					e.setLabel(EdgeLabel.DISCOVERY);
					DFS(G, w);
				}
				else {
					e.setLabel(EdgeLabel.BLACK);
				}
			}
		}
	}
}
