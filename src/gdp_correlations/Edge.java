package gdp_correlations;


public class Edge {
	Vertex a;
	Vertex b;
	String label;
	Double weight;
	
	public Edge(Vertex a, Vertex b) {
		
		this.a = a;
		this.b = b;		
		this.label = "UNEXPLORED";
	}
	
	public Edge(Vertex a, Vertex b, Double weight) {
		
		this.a = a;
		this.b = b;
		this.weight = weight;
		this.label = "UNEXPLORED";
		
	}
	
	public void printEdge() {
		System.out.println(a.id + " to " + b.id + " Label: " + label);
		
	}

	public void setLabel(String label) {
		this.label = label;		
	}
	
	public String getLabel() {
		return label;
	}
	
	public Edge conjugate() {
		Edge conjugate = new Edge(this.b, this.a);
		return conjugate;
	}
	
	public boolean equals(Edge e) {
		if (e == null) return false;
		
		if (e.a == this.a)
			if (e.b == this.b)
				return true;
		
		return false;
	}
	
}
