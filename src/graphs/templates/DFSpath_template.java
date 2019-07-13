package graphs.templates;

import java.util.List;
import java.util.Stack;

import graphs.graph.Edge;
import graphs.graph.EdgeLabel;
import graphs.graph.RGraph;
import graphs.graph.Vertex;
import graphs.graph.VertexLabel;

public interface DFSpath_template {
	default List<Vertex> DFSpath(RGraph G, Vertex from, Vertex to) {
		initResult(G);
		
		for (Vertex v : G.vertices()) {
			v.setLabel(VertexLabel.UNEXPLORED);
			postIndexVertex(v);
		}
		for (Edge e : G.edges()) {
			e.setLabel(EdgeLabel.UNEXPLORED);
			postIndexEdge(e);
		}
		
		Stack<Vertex> S = new Stack<Vertex>();
		
		for(Vertex v : G.vertices()) {
			if (isNextComponent(G, v, from)) {
				preVisitComponent(G, v);
				DFSpathHelper(G, v, to, S);
				postVisitComponent(G, v);
			}
		}
		
		return result(G);
	}
	
	// z - target
	default void DFSpathHelper(RGraph G, Vertex v, Vertex z, Stack<Vertex> S) {
		v.setLabel(VertexLabel.VISITED);
		startVertexVisit(G, v, z, S);
		
		for (Edge e : v.getIncidentEdges()) {
			if (e.getLabel() == EdgeLabel.UNEXPLORED) {
				Vertex w = G.opposite(v, e);
				if (w.getLabel() == VertexLabel.UNEXPLORED) {
					e.setLabel(EdgeLabel.DISCOVERY);
					preDiscoveryTraversal(G, v, e, w, z);
					DFSpathHelper(G, w, z, S);
					postDiscoveryTraversal(G, v, e, w, z);
				}
				else {
					e.setLabel(EdgeLabel.BLACK);
					backTraversal(G, v, e, w, z);
				}
			}
		}
		finishVertexVisit(G, v, z, S);
	}
	
	void initResult(RGraph G);
	
	void postIndexVertex(Vertex v);
	
	void postIndexEdge(Edge e);
	
	boolean isNextComponent(RGraph G, Vertex v, Vertex from);
	
	void preVisitComponent(RGraph G, Vertex v);
	
	void postVisitComponent(RGraph G, Vertex v);
	
	List<Vertex> result(RGraph G);
		
	void startVertexVisit(RGraph G, Vertex v, Vertex z, Stack<Vertex> S);
	
	void preDiscoveryTraversal(RGraph G, Vertex v, Edge e, Vertex w, Vertex z);
	
	void postDiscoveryTraversal(RGraph G, Vertex v, Edge e, Vertex w, Vertex z);
	
	void backTraversal(RGraph G, Vertex v, Edge e, Vertex w, Vertex z);

	void finishVertexVisit(RGraph G, Vertex v, Vertex z, Stack<Vertex> S);
	
}
