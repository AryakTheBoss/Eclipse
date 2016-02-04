package shit;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class AcroRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner s = new Scanner(new File("C:\\Users\\17ap0497\\Downloads\\acro.dat"));
		String gg = "";
for(int i=8;i>0;i--){
			
			s.nextLine();
			
		}


Acronyms a = new Acronyms();

out.println(a+"\n\n");

while(s.hasNextLine()){
	
	out.println(a.convert(s.nextLine()));
	
}


		
	}
}