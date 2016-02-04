package pq;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class OddRunner
{
	public static void main( String args[] ) throws IOException
	{
		//more test cases
				File io = new File("C:\\Users\\17ap0497\\Downloads\\oddevendata.dat");
				if(!io.exists()){
					
					err.println("No File m8");
					exit(0);
				}
				OddEvenSets oes = new OddEvenSets();
				Scanner s = new Scanner(io);
			
				while(s.hasNextLine()){
					
					oes.addLine(s.nextLine());
					out.println(oes);
					
					oes.clear();
				}
				s.close();
				
	}
}