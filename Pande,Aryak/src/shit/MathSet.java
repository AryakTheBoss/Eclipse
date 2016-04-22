//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -  
//Lab  -  
package shit;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

import static java.lang.System.*;

public class MathSet
{
	private Set<Integer> one = new TreeSet<Integer>();
	private Set<Integer> two= new TreeSet<Integer>();

	public MathSet()
	{
	}
	public void clear(){
		one.clear();
		two.clear();
	}
	public MathSet(String o, String t)
	{
		
		addSet(o,t);
		
	}
	public void addSet(String o, String t){
		
		String[] ll = o.split(" ");
		for(String s : ll){
			one.add(Integer.parseInt(s)); 
		}
		String[] l2 = t.split(" ");
		for(String s : l2){
			two.add(Integer.parseInt(s)); 
		}
		
	}
	public Set<Integer> union()
	{
		Set<Integer> lel = new TreeSet<Integer>();
		lel.addAll(one);
		lel.addAll(two);
		return lel;
	}

	public Set<Integer> intersection()
	{
		Set<Integer> lel = new TreeSet<Integer>();
		
		for(Integer i : one){
			
			if(two.contains(i)){ 
				lel.add(i);
				
			}
			
		}
		return lel;
	}

	public Set<Integer> differenceAMinusB()
	{
		Set<Integer> lel = new TreeSet<Integer>();
		for(Integer i : one){
			
			if(!two.contains(i)){
				lel.add(i);
			}
			
		}
		return lel;
	}

	public Set<Integer> differenceBMinusA()
	{
		Set<Integer> lel = new TreeSet<Integer>();
		for(Integer i : two){
			
			if(!one.contains(i)){
				lel.add(i);
			}
			
		}
		return lel;
	}
	
	public Set<Integer> symmetricDifference()
	{		
		Set<Integer> lel = new TreeSet<Integer>();
		lel.addAll(differenceAMinusB());
		lel.addAll(differenceBMinusA());
		return lel;
	}	
	
	public String toString()
	{
		return "Set one " + one + "\n" +	"Set two " + two +  "\n";
	}
}