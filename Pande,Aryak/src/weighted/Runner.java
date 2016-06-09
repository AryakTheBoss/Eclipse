package weighted;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner file = new Scanner(new File("H:\\grap.dat"));
		WeightedGraph g = new WeightedGraph(file);
		
		
		System.out.println("Connections,Distance,SpeedLimit,Cost\nAB 1 10 1\nBC 2 15 0\nCD 1 10 0\nDE 2 50 5\nEA 2 40 5\nAF 1 5 20\nFD 2 8 10");
		
		g.check("AD", Weighted.TIME);
		System.out.println("A ~> D (Shortest Time): "+g.shortestTime + " minutes");
		g.check("AD", Weighted.DISTANCE);
		System.out.println("A ~> D (Shortest Distance): "+g.shortestDistance + " miles");
		g.check("AD", Weighted.COST);
		System.out.println("A ~> D (Smallest Cost): "+g.shortestCost + " dollars");
		file.close();
	}
}