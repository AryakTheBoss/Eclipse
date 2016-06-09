package butthole;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -  
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;

public class ShortestPathGraphRunner
{
	public static void main( String[] args ) throws IOException
	{
		Scanner file = new Scanner(new File("H:\\graph2.dat"));
		
		int howManyTimes = Integer.parseInt(file.nextLine());
		
		for (int x = 0; x < howManyTimes; x++) {
			
			//WeightedEngs g = new WeightedEngs(" " + file.nextLine());
			ShortestPathGraph g = new ShortestPathGraph(" " + file.nextLine());
			
			String check = file.nextLine();
			
			//ArrayList<Path> arr = new ArrayList<Path>();
			ArrayList<String> arr = new ArrayList<String>();
			
			//arr.add(new Path(0.0,5,5/45,check.substring(0, 1)));
			arr.add(check.substring(0, 1));
			
			g.check(check.substring(0, 1), check.substring(1), arr, 1);
			
			System.out.println(check.substring(0, 1) + " ~> "
					+check.substring(1) + " == " + g.match + " in "
					+ g.shortest + " steps");
		}

		file.close();
	}
}