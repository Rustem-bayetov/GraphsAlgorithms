package graphs;

import java.util.Stack;
import graphs.graph.*;

public class Graph_DFSpath {
	static Graph_DFSpath INSTANCE = new Graph_DFSpath();
	
	// Finding path using DFS
	public static void main(String[] args) {
		RGraph graph = GraphFactory.initGraph3();		
		graph.print();
		
		Stack<Vertex> p = INSTANCE.pathDFS(graph, graph.findVertex("A"), graph.findVertex("F"));		
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
		if (v.getName() == z.getName())
			path = (Stack<Vertex>) S.clone();
		
		for (Edge e : v.getIncidentEdges()) {
			if (e.getLabel() == EdgeLabel.UNEXPLORED) {
				Vertex w = G.opposite(v, e);
				if (w.getLabel() == VertexLabel.UNEXPLORED) {
					e.setLabel(EdgeLabel.DISCOVERY);
					pathDFSHelper(G, w, z, S);
				}
				else {
					e.setLabel(EdgeLabel.BLACK);
				}
			}
		}
		S.pop();
	}
}
