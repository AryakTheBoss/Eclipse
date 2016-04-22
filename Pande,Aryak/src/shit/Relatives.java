package shit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Scanner;

import static java.lang.System.*;

public class Relatives
{
	private Map<String,Set<String>> map = new TreeMap<String,Set<String>>();
private String nulls = "";
;	public Relatives() throws FileNotFoundException
	{
		
		Scanner s = new Scanner(new File("C:\\Users\\17ap0497\\Downloads\\relatives.dat"));
		String line = null;
		while(s.hasNextLine()){
			line = s.nextLine();
			if(!line.isEmpty())
			setPersonRelative(line);
			
		}

	}

	public void setPersonRelative(String line)
	{
		String[] personRelative = line.split(" ");
		
		if(map.containsKey(personRelative[0])){
			try{
			map.get(personRelative[0]).add(personRelative[1]);
			}catch(ArrayIndexOutOfBoundsException e){
				nulls += personRelative[0]+" ";
			}
		
		}else{
			map.put(personRelative[0], new TreeSet<String>());
			map.get(personRelative[0]).add(personRelative[1]);
		}









	}


	public String getRelatives(String person)
	{
		return map.get(person).toString().replaceAll("\\[|\\]|,", " "); 
	}


	public String toString()
	{
		String output="";
		Iterator<String> i = map.keySet().iterator();
		String first = null;
		while(i.hasNext()){
			first = i.next();
			output += "\n"+first+" is related to "+getRelatives(first);
			
		}

		String[] yolo = nulls.split(" ");
output += "\n\n";
		for(String s : yolo){
			
			output+=s+" is related to "+map.get(s).toString()+"\n";
			
		}


		return output;
	}
}