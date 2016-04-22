//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
package shit;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import pq.OddEvenSets;
import static java.lang.System.*;

public class MathSetRunner
{
	public static void main(String args[]) throws IOException
	{
		//add test cases
		File io = new File("C:\\Users\\17ap0497\\Downloads\\mathsetdata.dat");
		if(!io.exists()){
			
			err.println("No File m8");
			exit(0);
		}
		MathSet oes = new MathSet();
		Scanner s = new Scanner(io);
	String one,two=null;
		while(s.hasNextLine()){
			one = s.nextLine();
			if(s.hasNextLine())
			two = s.nextLine();
			else
				break;
			oes.addSet(one,two);
			out.println(oes);
			out.println("union - "+oes.union());
			out.println("intersection - "+oes.intersection());
			out.println("diffa-b - "+oes.differenceAMinusB());
			out.println("diffb-a - "+oes.differenceBMinusA());
			out.println("sym - "+oes.symmetricDifference());
			out.println("\n");
			oes.clear();
		}
		s.close();
	}
}
