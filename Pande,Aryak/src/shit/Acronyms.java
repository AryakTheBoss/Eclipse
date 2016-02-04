package shit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Acronyms
{
	private Map<String,String> ac = new TreeMap<String,String>();

	public Acronyms() throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("C:\\Users\\17ap0497\\Downloads\\acro.dat"));
		
		for(int i=8;i>0;i--){
			
			putEntry(s.nextLine());
			
		}
		
		s.close();

	}

	public void putEntry(String entry)
	{
		String[] lol = entry.split("-");
		ac.put(lol[0].replace(" ", ""), lol[1]);



	}

	public String convert(String sent)
	{
		Scanner chop = new Scanner(sent);
		String output ="";
		String rekt = "";
		//System.out.println(ac.get("FG.".replace(".", "")));
		while(chop.hasNext()){
			rekt = chop.next();
			
			output += ac.containsKey(rekt.replace(".", "")) ? ac.get(rekt.replace(".", "")) + " " : rekt + " ";	
			
		}








		return output;
	}

	public String toString()
	{
		return ac.toString();
	}
}