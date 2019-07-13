package graphs.templates.examples;

import java.util.List;

import graphs.GraphFactory;
import graphs.graph.Edge;
import graphs.graph.RGraph;
import graphs.graph.Vertex;
import graphs.graph.VertexLabel;
import graphs.templates.BFSpath_template;

public class Graph_BFSbasic implements BFSpath_template {
	static Graph_BFSbasic INSTANCE = new Graph_BFSbasic();

	// Basic traversing using BFS.
	public static void main(String[] args) {
		RGraph G = GraphFactory.initGraph2();
		G.print();

		List<Vertex> result = INSTANCE.BFSpath(G, G.findVertex("A"), null);
		G.print();
		System.out.println("Result path: " + result);
		System.out.println("Hops count: " + G.getHopsCount());
	}

	@Override
	public void initResult(RGraph G) {
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
		return null;
	}

	@Override
	public void startBFS(RGraph G, Vertex from, Vertex to) {
	}

	@Override
	public void preVertexVisit(RGraph G, Vertex v, Vertex to) {
		G.hopsCountInc();
		System.out.println("hop " + G.getHopsCount() + ": " + v);
	}

	@Override
	public boolean canTerminate(Vertex v) {
		return false;
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
	}
}
