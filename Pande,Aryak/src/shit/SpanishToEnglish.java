package shit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

import static java.lang.System.*;

public class SpanishToEnglish
{
	private Map<String,String> pairs;
	private Scanner s;

	public SpanishToEnglish() throws FileNotFoundException
	{
		s = new Scanner(new File("C:\\Users\\17ap0497\\Downloads\\spantoeng.dat"));
		pairs = new TreeMap<String,String>();
		for(int i=0;i<46;i++){
			
			putEntry(s.nextLine());
			
		}

	}

	public void putEntry(String entry)
	{
		String[] list = entry.split(" ");
		
		pairs.put(list[0], list[1]);
		
		


	}

	public String translate(String sent)
	{
		String[] words = sent.split(" ");
		String output ="";
		for(int i=0;i<words.length;i++){
			
			output += pairs.get(words[i])+" ";
			
		}		


		return output;
	}

	public String toString()
	{
		return pairs.toString().replaceAll("\\,","\n");
	}
}