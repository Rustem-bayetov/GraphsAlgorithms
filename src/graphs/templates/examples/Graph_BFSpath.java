package graphs.templates.examples;

import java.util.LinkedList;
import java.util.List;

import graphs.GraphFactory;
import graphs.graph.Edge;
import graphs.graph.RGraph;
import graphs.graph.Vertex;
import graphs.graph.VertexLabel;
import graphs.templates.BFSpath_template;

public class Graph_BFSpath implements BFSpath_template {
	static Graph_BFSpath INSTANCE = new Graph_BFSpath();

	// Find shortest path using BFS.
	// For graphs where all edges have same weight
	public static void main(String[] args) {
		RGraph G = GraphFactory.initGraph3();
		G.print();

		List<Vertex> result = INSTANCE.BFSpath(G, G.findVertex("A"), G.findVertex("F"));
		G.print();
		System.out.println("Result path: " + result);
		System.out.println("Hops count: " + G.getHopsCount());
	}

	private boolean targetFound;
	LinkedList<Vertex> Res;

	@Override
	public void initResult(RGraph G) {
		targetFound = false;
		Res = new LinkedList<Vertex>();
	}

	@Override
	public void postIndexVertex(Vertex v) {
		v.setParent(null);
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
		return Res;
	}

	@Override
	public void startBFS(RGraph G, Vertex from, Vertex to) {
	}

	@Override
	public void preVertexVisit(RGraph G, Vertex v, Vertex to) {
		G.hopsCountInc();
		System.out.println("hop " + G.getHopsCount() + ": " + v);
		if (v == to)
			targetFound = true;
	}

	@Override
	public boolean canTerminate(Vertex v) {
		return targetFound;
	}

	@Override
	public void preEdgeVisit(RGraph G, Vertex v, Edge e, Vertex w) {
	}

	@Override
	public void preDiscoveryEdge(RGraph G, Vertex v, Edge e, Vertex w) {
	}

	@Override
	public void postDiscoveryEdge(RGraph G, Vertex v, Edge e, Vertex w) {
		if (w.getParent() == null)
			w.setParent(v);
	}

	@Override
	public void crossEdge(RGraph G, Vertex v, Edge e, Vertex w) {
	}

	@Override
	public void postVertexVisit(RGraph G, Vertex v, Vertex to) {
	}

	@Override
	public void finishBFS(RGraph G, Vertex from, Vertex to) {
		if (targetFound) {
			Vertex v = to;
			while (v != null) {
				Res.addFirst(v);
				v = v.getParent();
			}
		}
	}
}
