package graphs.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


// This code was written by Rustem Bayetov in July 2019 
// For studying Algorithms in MUM with professor Clyde D. Ruby Ph.D.
// Use this code for educational purposes

public class RGraph {
	List<Edge> _edges;
	List<Vertex> _vertices;
	
	private int hopsCount;
	
	public RGraph() {
		_edges = new ArrayList<Edge>();
		_vertices = new ArrayList<Vertex>();
	}
	
	public Vertex insertVertex(String name) {
		Vertex v = new Vertex(name, new ArrayList<Edge>(), VertexLabel.UNEXPLORED);
		_vertices.add(v);
		return v;
	}

	public Edge insertEdge(String vertexA, String vertexB) {
		return insertEdge(vertexA, vertexB, -1, false);
	}
	
	public Edge insertEdge(String vertexA, String vertexB, int weight) {
		return insertEdge(vertexA, vertexB, weight, false);
	}
	
	public Edge insertDirectedEdge(String vertexA, String vertexB) {
		return insertEdge(vertexA, vertexB, -1, true);
	}
	
	public Edge insertDirectedEdge(String vertexA, String vertexB, int weight) {
		return insertEdge(vertexA, vertexB, weight, true);
	}

	private Edge insertEdge(String vertexA, String vertexB, int weight, Boolean directed) {
		Vertex va = findVertex(vertexA);
		Vertex vb = findVertex(vertexB);
		Edge e = new Edge(va, vb, weight, directed, EdgeLabel.UNEXPLORED);
		_edges.add(e);
		va.IncidentEdges.add(e);
		vb.IncidentEdges.add(e);
		return e;
	}
	
	public Vertex findVertex(String name) {
		Optional<Vertex> v = _vertices.stream().filter(x -> x.getName() == name).findFirst();
		
		// if not found we can throw an exception
		return v.orElse(null);
	}
	
	public Vertex opposite(Vertex v, Edge e) {
		if (e.getVertexA() == v) 
			return e.getVertexB();
		else
			return e.getVertexA();					
	}
	
	public List<Edge> incidentEdges(Vertex v) {
		return v.IncidentEdges;
	}
	
	public List<Vertex> endVertices(Edge e) {
		List<Vertex> vx = new ArrayList<Vertex>();
		vx.add(e.vertexA);
		if (!e.isDirected()) vx.add(e.vertexB);
		return vx;
	}
	
	public Boolean isDirected(Edge e) {
		return e.isDirected();
	}
	
	public Boolean areAdjacent(Vertex v1, Vertex v2) {
		for(Edge e1 : v1.IncidentEdges) {
				if (opposite(v1, e1) == v2) return true;
		}
		
		return false;
	}
	
	public List<Vertex> vertices(){
		return _vertices;
	}
	
	public List<Edge> edges(){
		return _edges;
	}
	
	public int numVertices() {
		return _vertices.size();
	}
	
	public int numEdges() {
		return _edges.size();
	}
	
	public void print() {
		System.out.println("Vertices: " );
		for(Vertex v : _vertices) {
			System.out.println(v.getVertexString());
		}
		
		// print help
		System.out.println("Vertex^Parent_Weight - UNEXPLORED; = DISCOVERY; ~ BLACK or CROSS\r\n");
	}
		
	public void setUnexplored() {
		hopsCount = 0;
		for (Vertex vertex : _vertices) {
			vertex.label = VertexLabel.UNEXPLORED;
		}
		for (Edge edge : _edges) {
			edge.label = EdgeLabel.UNEXPLORED;
		}
	}
	
	public int getHopsCount() {
		return hopsCount;
	}
	
	public void hopsCountInc() {
		hopsCount++;
	}
	
	public void hopsCountReset() {
		hopsCount = 0;
	}
}
