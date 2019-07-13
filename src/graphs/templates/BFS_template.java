package graphs.templates;

import java.util.LinkedList;
import java.util.List;

import graphs.graph.Edge;
import graphs.graph.EdgeLabel;
import graphs.graph.RGraph;
import graphs.graph.Vertex;
import graphs.graph.VertexLabel;

public interface BFS_template {
	default List<Vertex> BFSpath(RGraph G) {
		initResult(G);
		
		for(Vertex v : G.vertices()) {
			v.setLabel(VertexLabel.UNEXPLORED);
			postIndexVertex(v);
		}
		
		for(Edge e : G.edges()) {
			e.setLabel(EdgeLabel.UNEXPLORED);
			postIndexEdge(e);
		}
		
		for(Vertex v : G.vertices()) {
			if (isNextComponent(G, v)) {
				preVisitComponent(G, v);
				BFSpathHelper(G, v);
				postVisitComponent(G, v);
			}
		}
		
		return result(G);
	}
	
	default void BFSpathHelper(RGraph G, Vertex s) {
		LinkedList<Vertex> L = new LinkedList<Vertex>();
		L.addLast(s);
		s.setLabel(VertexLabel.VISITED);
		
		startBFS(G, s);
		
		while(!L.isEmpty()) {
			Vertex v = L.removeFirst();
			
			preVertexVisit(G, v);
			if (canTerminate()) break;
			
			for (Edge e : G.incidentEdges(v)) {
				if (e.getLabel() == EdgeLabel.UNEXPLORED) {
					Vertex w = G.opposite(v, e);
					preEdgeVisit(G, v, e, w);
					
					if (w.getLabel() == VertexLabel.UNEXPLORED) {
						preDiscoveryEdge(G, v, e, w);
						e.setLabel(EdgeLabel.DISCOVERY);
						w.setLabel(VertexLabel.VISITED);
						L.addLast(w);
						postDiscoveryEdge(G, v, e, w);
					}
					else {
						e.setLabel(EdgeLabel.CROSS);
						crossEdge(G, v, e, w);
					}
				}
			}
			
			postVertexVisit(G, v);
		}
		
		finishBFS(G, s);
	}
	
	void initResult(RGraph G);
	
	void postIndexVertex(Vertex v);
	
	void postIndexEdge(Edge e);
	
	boolean isNextComponent(RGraph G, Vertex v);
	
	void preVisitComponent(RGraph G, Vertex v);
	
	void postVisitComponent(RGraph G, Vertex v);
	
	List<Vertex> result(RGraph G);
	
	void startBFS(RGraph G, Vertex v);
	
	void preVertexVisit(RGraph G, Vertex v);
	
	boolean canTerminate();
	
	void preEdgeVisit(RGraph G, Vertex v, Edge e, Vertex w);
	
	void preDiscoveryEdge(RGraph G, Vertex v, Edge e, Vertex w);
	
	void postDiscoveryEdge(RGraph G, Vertex v, Edge e, Vertex w);
	
	void crossEdge(RGraph G, Vertex v, Edge e, Vertex w);

	void postVertexVisit(RGraph G, Vertex v);
	
	void finishBFS(RGraph G, Vertex from);	
}
