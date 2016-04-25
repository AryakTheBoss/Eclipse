/**
 * 
 */
package shit;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



/**
 * @author 17ap0497
 *
 */
public class TeamSet {
	
	private Set<Wrestler> lol = new HashSet<Wrestler>();
	
	public TeamSet(){
		
		
		
	}
	
	public void add(Wrestler w){
		
		lol.add(w);
		
	}
	
	public int getAvgWeight(){
		
		Iterator<Wrestler> i = lol.iterator();
		int total = 0;
		while(i.hasNext()){
			
			total += i.next().getWeight();
			
		}
		return total/lol.size();
		
	}
	public void remove(Wrestler w){
		
		lol.remove(w);
		
	}
	public String toString(){
		
		return lol.toString();
		
	}

}
