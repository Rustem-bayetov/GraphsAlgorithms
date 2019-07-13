package graphs.graph;

import java.util.List;

public class Vertex {
	String name;
	List<Edge> IncidentEdges;
	VertexLabel label;
	Vertex parent;
	int weight;

	public Vertex(String name, List<Edge> incidentEdges, VertexLabel label) {
		super();
		this.name = name;
		IncidentEdges = incidentEdges;
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public List<Edge> getIncidentEdges() {
		return IncidentEdges;
	}

	public VertexLabel getLabel() {
		return label;
	}
	
	public Vertex getParent() {
		return parent;
	}

	public int getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public String getVertexString() {
		String s = "";
		for(Edge e : IncidentEdges) {
			String tire = "-";
			if (e.getLabel() == EdgeLabel.DISCOVERY) tire = "=";
			if (e.getLabel() == EdgeLabel.BLACK || e.getLabel() == EdgeLabel.CROSS) tire = "~";
			if (e.directed) tire += ">";
			
			s += "(" + e.getVertexA().getName() + tire + (e.getWeight() != -1 ? e.getWeight() + tire : "") + e.getVertexB().getName() + "), ";
		}
		if (!s.isEmpty()) s = s.substring(0, s.length() - 2);
		String vInfo = name;
		if (parent != null) vInfo += "^" + parent.name;
		if (weight > 0) vInfo += "_" + (weight == Integer.MAX_VALUE ? "inf" : weight);
		
		return vInfo + ":[" + s + "]";
	}

	public void setLabel(VertexLabel label) {
		this.label = label;
	}

	public void setParent(Vertex parent) {
		this.parent = parent;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
