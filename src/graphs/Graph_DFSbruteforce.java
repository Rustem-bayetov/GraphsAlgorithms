package graphs;

import java.util.Stack;

import graphs.graph.Edge;
import graphs.graph.EdgeLabel;
import graphs.graph.RGraph;
import graphs.graph.Vertex;
import graphs.graph.VertexLabel;

public class Graph_DFSbruteforce {
	static Graph_DFSbruteforce INSTANCE = new Graph_DFSbruteforce();
	
	// Finding shortest path using DFS. 
	// Traversing whole tree
	public static void main(String[] args) {
		RGraph graph = GraphFactory.initGraph1();
		graph.print();
		
		Stack<Vertex> p = INSTANCE.pathDFS(graph, graph.findVertex("A"), graph.findVertex("E"));		
		graph.print();
		
		System.out.println("Result path: " + p);
		System.out.println("Hops count: " + graph.getHopsCount());
	}

	Stack<Vertex> path;
	public Stack<Vertex> pathDFS(RGraph G, Vertex from, Vertex to) {
		G.setUnexplored();
		Stack<Vertex> S = new Stack<Vertex>();
		path = new Stack<Vertex>();
		pathDFSHelper(G, from, to, S);
		System.out.println();
		return path;
	}
	
	@SuppressWarnings("unchecked")
	public void pathDFSHelper(RGraph G, Vertex v, Vertex z, Stack<Vertex> S) {
		G.hopsCountInc();
		v.setLabel(VertexLabel.VISITED);
		S.push(v);
		System.out.println("hop " + G.getHopsCount() + ": " + v + " = " + S);
		if (v.getName() == z.getName() && ((S.size() < path.size() && path.size() > 0) || (path.size() == 0)))
			path = (Stack<Vertex>) S.clone();
		
		for (Edge e : v.getIncidentEdges()) {
			if (e.getLabel() == EdgeLabel.UNEXPLORED) {
				Vertex w = G.opposite(v, e);
				if (w.getLabel() == VertexLabel.UNEXPLORED) {
					e.setLabel(EdgeLabel.DISCOVERY);
					pathDFSHelper(G, w, z, S);
					// added set label UNEXPLORED
					e.setLabel(EdgeLabel.UNEXPLORED);
				}
				else {
//					G.setEdgeLabel(e, EdgeLabel.BLACK);
				}
			}
		}
		v.setLabel(VertexLabel.UNEXPLORED);
		S.pop();
		
	}
}
