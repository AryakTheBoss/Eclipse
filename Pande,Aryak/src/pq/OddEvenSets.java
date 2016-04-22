package pq;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class OddEvenSets
{
	private Set<Integer> odds = new TreeSet<Integer>();
	private Set<Integer> evens = new TreeSet<Integer>();

	public OddEvenSets()
	{
	}

	public void addLine(String line){
		String[] ll = line.split(" ");
		for(String s : ll){
			add(Integer.parseInt(s));
		}
	}
public void clear(){
	odds.clear();
	evens.clear();
}
	public OddEvenSets(String line)
	{
		addLine(line);
	}
private void add(int lel){
	
	if(lel % 2 == 0)
		evens.add(lel);
	else
		odds.add(lel);
	
}
	public String toString()
	{
		return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
	}
}