package graphs.templates;

import graphs.graph.Edge;
import graphs.graph.EdgeLabel;
import graphs.graph.RGraph;
import graphs.graph.Vertex;
import graphs.graph.VertexLabel;

public interface DFS_template {	
	default void DFS(RGraph G, Vertex v) {
		v.setLabel(VertexLabel.VISITED);
		startVertexVisit(G, v);
		
		for (Edge e : v.getIncidentEdges()) {
			if (e.getLabel() == EdgeLabel.UNEXPLORED) {
				Vertex w = G.opposite(v, e);
				if (w.getLabel() == VertexLabel.UNEXPLORED) {
					e.setLabel(EdgeLabel.DISCOVERY);
					preDiscoveryTraversal(G, v, e, w);
					DFS(G, w);
					postDiscoveryTraversal(G, v, e, w);
				}
				else {
					e.setLabel(EdgeLabel.BLACK);
					backTraversal(G, v, e, w);
				}
			}
		}
		finishVertexVisit(G, v);
	}
	
	void DFS(RGraph G);
	
	void startVertexVisit(RGraph G, Vertex v);
	
	void preDiscoveryTraversal(RGraph G, Vertex v, Edge e, Vertex w);
	
	void postDiscoveryTraversal(RGraph G, Vertex v, Edge e, Vertex w);
	
	void backTraversal(RGraph G, Vertex v, Edge e, Vertex w);

	void finishVertexVisit(RGraph G, Vertex v);
	
}
