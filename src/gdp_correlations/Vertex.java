package gdp_correlations;

import java.util.*;


public class Vertex {

	int id;
	ArrayList<Integer> connections;
	String label;
	Vertex back;
	
	public Vertex(int n) {
		
		this.connections = new ArrayList<Integer>();
		this.id = n;
		this.label = "UNEXPLORED";
		this.back = null;
	}
	
	public void setLabel(String label) {
		this.label = label;		
	}
	
	public String getLabel() {
		return label;
	}
	
	public void vPrint() {
		
		System.out.println("Node: " + id);
		System.out.println("Adjacent Nodes: " + this.connections.toString());
		
	}
}