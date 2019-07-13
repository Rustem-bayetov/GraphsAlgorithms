package graphs.templates.examples;

import java.util.List;
import java.util.Stack;

import graphs.GraphFactory;
import graphs.graph.Edge;
import graphs.graph.RGraph;
import graphs.graph.Vertex;
import graphs.graph.VertexLabel;
import graphs.templates.DFSpath_template;

public class Graph_DFSpath implements DFSpath_template {
	static Graph_DFSpath INSTANCE = new Graph_DFSpath();
	private Stack<Vertex> path;

	// Find path using DFS template
	public static void main(String[] args) {
		RGraph G = GraphFactory.initGraph4();
		G.print();
		List<Vertex> result = INSTANCE.DFSpath(G, G.findVertex("A"), G.findVertex("F"));
		G.print();
		System.out.println("Result path: " + result);
		System.out.println("Hops count: " + G.getHopsCount());
	}
			
	@SuppressWarnings("unchecked")
	@Override
	public void startVertexVisit(RGraph G, Vertex v, Vertex z, Stack<Vertex> S) {
		G.hopsCountInc();
		S.push(v);
		System.out.println("hop " + G.getHopsCount() + ": " + v + " = " + S);
		if (v.getName() == z.getName()) {
			path = (Stack<Vertex>)S.clone();
		}			
	}

	@Override
	public void preDiscoveryTraversal(RGraph G, Vertex v, Edge e, Vertex w, Vertex z) {
	}

	@Override
	public void postDiscoveryTraversal(RGraph G, Vertex v, Edge e, Vertex w, Vertex z) {
	}

	@Override
	public void backTraversal(RGraph G, Vertex v, Edge e, Vertex w, Vertex z) {
	}

	@Override
	public void finishVertexVisit(RGraph G, Vertex v, Vertex z, Stack<Vertex> S) {
		S.pop();		
	}

	@Override
	public void initResult(RGraph G) {
		G.hopsCountReset();
	}

	@Override
	public void postIndexVertex(Vertex v) {
	}

	@Override
	public void postIndexEdge(Edge e) {
	}

	@Override
	public boolean isNextComponent(RGraph G, Vertex v, Vertex from) {
		if (v.getLabel() == VertexLabel.UNEXPLORED)
			if (from == null || (from != null && v == from))
				return true;
		return false;
	}

	@Override
	public void preVisitComponent(RGraph G, Vertex v) {
	}

	@Override
	public void postVisitComponent(RGraph G, Vertex v) {
	}

	@Override
	public List<Vertex> result(RGraph G) {
		return path;
	}

}
