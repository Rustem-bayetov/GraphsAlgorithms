package graphs.templates.examples;

import graphs.GraphFactory;
import graphs.graph.Edge;
import graphs.graph.EdgeLabel;
import graphs.graph.RGraph;
import graphs.graph.Vertex;
import graphs.graph.VertexLabel;
import graphs.templates.DFS_template;

public class Graph_DFS implements DFS_template {
	static Graph_DFS INSTANCE = new Graph_DFS();
	
	// Basing traversing graph using DFS template
	public static void main(String[] args) {
		RGraph G = GraphFactory.initGraph1();
		G.print();
		INSTANCE.DFS(G);
		G.print();
	}
	
	@Override
	public void DFS(RGraph G) {
		G.hopsCountReset();
		for (Vertex v : G.vertices()) {
			v.setLabel(VertexLabel.UNEXPLORED);
		}
		for (Edge e : G.edges()) {
			e.setLabel(EdgeLabel.UNEXPLORED);
		}
		
		for (Vertex v : G.vertices()) {
			DFS(G, v);
		}
	}

	@Override
	public void startVertexVisit(RGraph G, Vertex v) {
		G.hopsCountInc();
	}

	@Override
	public void preDiscoveryTraversal(RGraph G, Vertex v, Edge e, Vertex w) {
	}

	@Override
	public void postDiscoveryTraversal(RGraph G, Vertex v, Edge e, Vertex w) {
	}

	@Override
	public void backTraversal(RGraph G, Vertex v, Edge e, Vertex w) {
	}

	@Override
	public void finishVertexVisit(RGraph G, Vertex v) {
	}

}
