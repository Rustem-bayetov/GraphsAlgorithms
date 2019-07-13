package graphs.templates.examples;

import java.util.LinkedList;
import java.util.List;

import graphs.GraphFactory;
import graphs.graph.Edge;
import graphs.graph.RGraph;
import graphs.graph.Vertex;
import graphs.graph.VertexLabel;
import graphs.templates.BFSpath_template;

public class Graph_BFScircle implements BFSpath_template {
	static Graph_BFScircle INSTANCE = new Graph_BFScircle();

	// Find circle using BFS
	public static void main(String[] args) {
		RGraph G = GraphFactory.initGraph5();
		G.print();

		List<Vertex> result = INSTANCE.BFSpath(G, null, null);
		G.print();
		System.out.println("Result path: " + result);
		System.out.println("Hops count: " + G.getHopsCount());
	}

	private boolean circleFound;
	LinkedList<Vertex> Res;
	Vertex c1;
	Vertex c2;

	@Override
	public void initResult(RGraph G) {
		circleFound = false;
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
	}

	@Override
	public boolean canTerminate(Vertex v) {
		return circleFound;
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
		circleFound = true;
		c1 = v;
		c2 = w;
	}

	@Override
	public void postVertexVisit(RGraph G, Vertex v, Vertex to) {
	}

	@Override
	public void finishBFS(RGraph G, Vertex from, Vertex to) {
		if (c1 == null || c2 == null) return;
		
		LinkedList<Vertex> L1 = new LinkedList<Vertex>();
		while (c1 != null) {
			L1.addLast(c1);
			c1 = c1.getParent();
		}

		LinkedList<Vertex> L2 = new LinkedList<Vertex>();
		while (c2 != null) {
			L2.addLast(c2);
			c2 = c2.getParent();
		}
		
		// finding Vertex common for both Lists  
		Vertex p = null;		
		for (int i = 0; i < L1.size() && p == null; i++) {
			for (int j = 0; j < L2.size() && p == null; j++)
				if (L1.get(i) == L2.get(j)) 
					p = L1.get(i);
		}
		
		// if common Vertex found
		if (p != null) {
			while (L1.getFirst() != p) {
				Res.addLast(L1.removeFirst());
			}
			Res.add(p);
			while (L2.getFirst() != p) {
				Res.addFirst(L2.removeFirst());
			}
		}
	}
}
