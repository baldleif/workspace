package gdp_correlations;

import java.util.*;
import java.io.*;


public class CountryBin {

	int weocode;
	Double stdev;
	Double average;
	String countryname;
	String currency;
	String scale;
	ArrayList<Double> gdplist;
	
	public CountryBin() {
		
		weocode = 0;
		countryname = null;
		currency = null;
		scale = null;
		gdplist = new ArrayList<Double>();
		
	}
	
	public Double calcCorrelation(CountryBin b) {
		
		int i = 0;
		Double sum = new Double(0);
		
		while(i < 6) {
			
			if (this.gdplist.size() <= i|| b.gdplist.size() <= i)
				break;

			Double x = (this.gdplist.get(i) - this.average)/this.stdev;
			Double y = (b.gdplist.get(i) - b.average)/b.stdev;

			Double z = x*y;
			
			sum += z;
			
			++i;
		}
		
		sum = sum/i;
		
		return sum;
	}
	
	public void calcSigma() {
	
		Double summation = new Double(0);
		
		//Take the sum of gdplist and divide by n
		
		for (Double x1 : gdplist) 
			summation += x1;
		
		average = summation/gdplist.size();
		
		//Now we have the mean
		
		//Take the difference of the GDP by year and the mean
		//Sum all of the squares of the differences
		//Take the square root of the sum == std deviation
		
		summation = new Double(0);
	
		for (Double x1 : gdplist) {  // look at each year GDP
			Double x2 = x1 - average; // subtract the average from that year GDP
			
			summation += (x2*x2); // square the result and add it to a total sum	
		}
		
		summation = summation/gdplist.size();
	
		stdev = Math.sqrt(summation);
	}
	
	public void setCode(int weo) {
		weocode = weo;
	}
	
	public void setName(String name) {
		countryname = name;
	}
	
	public void setCurrency(String cur) {
		currency = cur;
	}
	
	public void setScale(String sc) {
		scale = sc;
	}
	
	public void add(Double num) {
		gdplist.add(num);
	}
	
	public void Print(PrintStream outfile) {
		
		outfile.printf(weocode + " " + countryname + " " + currency + " " + scale + " ");
		
		for (Double b : gdplist)
			outfile.printf(b + " ");
		
		outfile.println("Average GDP = " + average + " Standard Deviation = " + stdev);
	}
}
