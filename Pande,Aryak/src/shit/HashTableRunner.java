package shit;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import static java.lang.System.*;

public class HashTableRunner
{
  public static void main ( String[] args )
  {
		try{
			Scanner s = new Scanner(new File("C:\\Users\\17ap0497\\Downloads\\numbers.dat"));
			HashTable h = new HashTable();
			while(s.hasNextLine()){
				
				h.add(Integer.parseInt(s.nextLine()));
								
			}
			System.out.println(h);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
  }
}