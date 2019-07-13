package graphs.graph;

public class Edge {
	Vertex vertexA;
	Vertex vertexB;
	int weight;
	boolean directed;
	EdgeLabel label;

	public Edge(Vertex vertexA, Vertex vertexB, int weight, boolean unidirected, EdgeLabel label) {
		super();
		this.vertexA = vertexA;
		this.vertexB = vertexB;
		this.weight = weight;
		this.directed = unidirected;
		this.label = label;
	}

	public Vertex getVertexA() {
		return vertexA;
	}

	public Vertex getVertexB() {
		return vertexB;
	}

	public int getWeight() {
		return weight;
	}

	public boolean isDirected() {
		return directed;
	}

	public EdgeLabel getLabel() {
		return label;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setLabel(EdgeLabel label) {
		this.label = label;
	}

}
