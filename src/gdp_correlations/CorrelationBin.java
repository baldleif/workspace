package gdp_correlations;

import java.util.*;


public class CorrelationBin {

	final double T_VALUE = .40;

	Network G;
	Scanner fin;
	
	//Will scan in the file upon construction
	public CorrelationBin(Scanner fin) {
		
		G = new Network();
		this.fin = fin;
		
		populateNetwork();
		
	}
	
	public void populateNetwork() {
		
		while (fin.hasNextInt()) {
			
			int source = fin.nextInt();
			int dest = fin.nextInt();
			
			Double weight = fin.nextDouble();
			
			//FOR ALL EDGES (X, Y) IN |E|, IFF |C(X,Y)| > T (CHOOSE A VALUE T SUCH THAT THE EDGE DENSITY OF G IS BETWEEN 0.05 AND 0.50)
			if (Math.abs(weight) < T_VALUE) 
				continue; //omit this edge
			
			Vertex a = G.getVertex(source);
			Vertex b = G.getVertex(dest);
			
			if (a != null) a.connections.add(dest);
			
			else if (a == null) {
				
				a = new Vertex(source);
				a.connections.add(dest);
				G.vertices.add(a);
				
			}
			
			if (b == null) {
				
				b = new Vertex(dest);
				G.vertices.add(b);
				
			}
			
			G.insertDirectedEdge(a, b, weight);
			
		}
	}
}
