package gdp_correlations;

import java.io.*;

public class CountryCorrelation {
	
	int weo1;
	int weo2;
	double correlation;
	
	public CountryCorrelation(int a, int b, double r) {
		
		weo1 = a;
		weo2 = b;
		correlation = r;
	}
	
	public void Print(PrintStream outfile) {
		
		outfile.println(weo1 + " " + weo2 + " " + correlation);
		
		
	}
	
}
