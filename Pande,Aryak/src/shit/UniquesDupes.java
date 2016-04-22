package shit;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class UniquesDupes
{
	
	public static Set<String> getUniques(String input)
	{
		Set<String> uniques = new TreeSet<String>();
		String[] an0s = input.split(" ");
		
		for(String s : an0s){
			
			uniques.add(s);
			
		}

		return uniques;
	}

	public static Set<String> getDupes(String input)
	{
		Set<String> du = new TreeSet<String>();
		Set<String> dups = new TreeSet<String>();
		String[] an0s = input.split(" ");
		
		for(String s : an0s){
			
			if(!du.add(s)){
				dups.add(s);
			}
			
		}

		return dups;
	}
}