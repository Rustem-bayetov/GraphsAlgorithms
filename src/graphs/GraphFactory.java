package graphs;

import graphs.graph.RGraph;

public class GraphFactory {
	public static RGraph initGraph1() {
		RGraph graph = new RGraph();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.insertVertex("E");
		graph.insertEdge("A", "B");
		graph.insertEdge("A", "C");
		graph.insertEdge("A", "D");
		graph.insertEdge("B", "C");
		graph.insertEdge("C", "D");
		graph.insertEdge("A", "E");
		graph.insertEdge("C", "E");
		return graph;
	}
	
	public static RGraph initGraph2() {
		RGraph graph = new RGraph();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.insertVertex("E");
		graph.insertVertex("F");
		graph.insertEdge("A", "B");
		graph.insertEdge("A", "C");
		graph.insertEdge("A", "D");
		graph.insertEdge("B", "C");
		graph.insertEdge("B", "E");
		graph.insertEdge("C", "D");
		graph.insertEdge("C", "E");
		graph.insertEdge("C", "F");		
		graph.insertEdge("D", "F");
		
		return graph;
	}
	
	public static RGraph initGraph3() {
		RGraph graph = new RGraph();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.insertVertex("E");
		graph.insertVertex("F");
		graph.insertVertex("G");
		graph.insertVertex("H");
		graph.insertVertex("J");
		graph.insertEdge("A", "B");
		graph.insertEdge("A", "C");
		graph.insertEdge("A", "D");
		graph.insertEdge("B", "E");
		graph.insertEdge("C", "E");
		graph.insertEdge("C", "H");
		graph.insertEdge("C", "F");
		graph.insertEdge("D", "F");
		graph.insertEdge("E", "H");
		graph.insertEdge("H", "J");
		graph.insertEdge("J", "G");
		graph.insertEdge("F", "G");
		return graph;
	}
	
	public static RGraph initGraph4() {
		RGraph graph = new RGraph();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.insertVertex("E");
		graph.insertVertex("F");
		graph.insertVertex("G");
		graph.insertEdge("A", "B");
		graph.insertEdge("A", "C");
		graph.insertEdge("B", "C");		
		graph.insertEdge("G", "D");
		graph.insertEdge("G", "E");
		graph.insertEdge("G", "F");		
		
		return graph;
	}
	
	public static RGraph initGraph5() {
		RGraph graph = new RGraph();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.insertVertex("E");
		graph.insertEdge("A", "B");
		graph.insertEdge("B", "C");
		graph.insertEdge("C", "D");
		graph.insertEdge("D", "E");
		return graph;
	}
	
	public static RGraph initGraph6() {
		RGraph graph = new RGraph();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.insertVertex("E");
		graph.insertVertex("F");
		graph.insertEdge("A", "B", 8);
		graph.insertEdge("A", "C", 2);
		graph.insertEdge("A", "D", 4);
		graph.insertEdge("B", "C", 7);
		graph.insertEdge("B", "E", 2);
		graph.insertEdge("C", "E", 3);
		graph.insertEdge("C", "D", 1);
		graph.insertEdge("C", "F", 9);
		graph.insertEdge("D", "F", 5);
		return graph;
	}
	
	public static RGraph initGraph7() {
		RGraph graph = new RGraph();
		graph.insertVertex("A");
		graph.insertVertex("B");
		graph.insertVertex("C");
		graph.insertVertex("D");
		graph.insertVertex("E");
		graph.insertVertex("F");
		graph.insertVertex("G");
		graph.insertVertex("H");
		graph.insertEdge("A", "B", 4);
		graph.insertEdge("A", "C", 2);
		graph.insertEdge("B", "C", 3);
		graph.insertEdge("B", "E", 5);
		graph.insertEdge("C", "D", 8);
		graph.insertEdge("C", "E", 10);
		graph.insertEdge("D", "E", 4);
		graph.insertEdge("D", "G", 5);
		graph.insertEdge("E", "F", 7);
		graph.insertEdge("F", "G", 6);
		graph.insertEdge("F", "G", 6);
		graph.insertEdge("G", "H", 2);
		return graph;
	}
	
	public static RGraph initGraph8() {
		RGraph graph = new RGraph();
		graph.insertVertex("HNL");		// Honolulu
		graph.insertVertex("SFO");		// San Francisco
		graph.insertVertex("LAX");		// Los Angeles 
		graph.insertVertex("ORD");		// Chicago
		graph.insertVertex("DFW");		// Dallas - Fort Worth
		graph.insertVertex("LGA");		// New York - LaGuardia
		graph.insertVertex("PVD");		// Providence - TF Green
		graph.insertVertex("MIA");		// Miami
		graph.insertEdge("HNL", "LAX", 2555);
		graph.insertEdge("SFO", "LAX", 337);
		graph.insertEdge("SFO", "ORD", 1843);
		graph.insertEdge("LAX", "ORD", 1743);
		graph.insertEdge("LAX", "DFW", 1233);
		graph.insertEdge("ORD", "DFW", 802);
		graph.insertEdge("ORD", "PVD", 849);
		graph.insertEdge("DFW", "LGA", 1387);
		graph.insertEdge("DFW", "MIA", 1120);
		graph.insertEdge("LGA", "PVD", 142);
		graph.insertEdge("LGA", "MIA", 1099);
		graph.insertEdge("PVD", "MIA", 1205);
		return graph;
	}
	
	public static RGraph initGraph9() {
		RGraph graph = new RGraph();
		graph.insertVertex("SFO");		// San Francisco
		graph.insertVertex("LAX");		// Los Angeles 
		graph.insertVertex("ORD");		// Chicago
		graph.insertVertex("DFW");		// Dallas - Fort Worth
		graph.insertVertex("JFK");		// New York - Kennedy
		graph.insertVertex("BWI");		// Baltimore/Washington International
		graph.insertVertex("PVD");		// Providence - TF Green
		graph.insertVertex("BOS");		// Boston
		graph.insertVertex("MIA");		// Miami
		
		graph.insertEdge("SFO", "LAX", 337);
		graph.insertEdge("SFO", "BOS", 2704);
		graph.insertEdge("SFO", "ORD", 1846);
		graph.insertEdge("SFO", "DFW", 1464);		
		
		graph.insertEdge("LAX", "DFW", 1235);
		graph.insertEdge("LAX", "MIA", 2342);
		
		graph.insertEdge("ORD", "BOS", 867);
		graph.insertEdge("ORD", "PVD", 849);
		graph.insertEdge("ORD", "JFK", 740);
		graph.insertEdge("ORD", "BWI", 621);
		graph.insertEdge("ORD", "DFW", 802);
		
		graph.insertEdge("DFW", "JFK", 1391);
		graph.insertEdge("DFW", "MIA", 1121);
		
		graph.insertEdge("BOS", "JFK", 187);
		graph.insertEdge("BOS", "MIA", 1258);
		
		graph.insertEdge("PVD", "JFK", 144);
		graph.insertEdge("JFK", "BWI", 184);
		graph.insertEdge("JFK", "MIA", 1090);

		graph.insertEdge("BWI", "MIA", 946);

		return graph;
	}

}
