/**
 * 
 */
package butthole;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author 17ap0497
 *
 */
public class PhoneBook {
	
	private Hashtable<Character,LinkedList<PhoneEntry>> gg;
	private int numSlots = 0;
	public PhoneBook(){
		
		gg = new Hashtable<Character,LinkedList<PhoneEntry>>();
		try {
			
			load();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public PhoneBook(int numSlots){
		this.numSlots = numSlots;
		gg = new Hashtable<Character,LinkedList<PhoneEntry>>(numSlots);
		try {
			load();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void add(PhoneEntry e){
		//System.out.println(e+" "+e.hashCode());
		if(gg.get((char)e.hashCode()) == null){
			gg.put((char)e.hashCode(), new LinkedList<PhoneEntry>());
			gg.get((char)e.hashCode()).add(e);
		}else{
			gg.get((char)e.hashCode()).add(e);
		}
		
	}
	public void display(){
		
		System.out.println(gg.toString());
		
	}
	public int getCapacity(){
		
		return gg.size();
		
	}
	
	public int getSize(){
		
		Iterator<Character> li = gg.keySet().iterator();
		Iterator<PhoneEntry> pe;
		char s = 0;
		int count = 0;
		while(li.hasNext()){
			s = li.next();
			pe = gg.get(s).iterator();
			while(pe.hasNext()){
				count++;
				pe.next();
			}
		}
		return count;
		
		
	}
	public void load() throws FileNotFoundException{
		
		Scanner s = new Scanner(new File("C:\\Users\\17ap0497\\Downloads\\phonek.txt"));
		String ss;
		String[] kek;
		while(s.hasNextLine()){
			
			ss = s.nextLine().replaceAll("\\s+"," ");
			kek = ss.split(" ");
			add(new PhoneEntry(kek[0],kek[1]));
		}
		s.close();
		
		
	}
	
	public int getNumberOfNulls(){
		int count =0;
		for(int i=0;i<10;i++){
			
			if(gg.get(i)==null)
				count++;
			
		}
		return count;
		
	}
	
	public int getLongestList(){
		
		Iterator<Character> li = gg.keySet().iterator();
		int longest = 0;
		int current = 0;
		while(li.hasNext()){
			current = gg.get(li.next()).size();
			if(longest < current)
				longest = current;
			
		}
		
		return longest;
		
	}
	
	public String lookup(String lookFor){
		
		 LinkedList<PhoneEntry> s = gg.get(lookFor.charAt(0));
		 try{
		return s.get(findEntryy(s,lookFor)).toString();
		 }catch (IndexOutOfBoundsException e){
			 return "null";
		 }
		
	}
	public String findEntry(LinkedList<PhoneEntry> g,String look){
		
		for(int i=0;i<g.size();i++){
			
			if(g.get(i).getName().equals(look))
			return g.get(i).getNumber();
		}
		return null;
		
	}
public int findEntryy(LinkedList<PhoneEntry> g,String look){
		
		for(int i=0;i<g.size();i++){
			
			if(g.get(i).getName().equals(look))
			return i;
		}
		return -1;
		
	}
	public void changeNumber(String lookFor, String newNumb){
		
		 LinkedList<PhoneEntry> s = gg.get((char)lookFor.hashCode());
		 try{
		 s.get(findEntryy(s,lookFor)).setNumber(newNumb);
		 }catch (IndexOutOfBoundsException e){
			 e.printStackTrace();
		 }
		
	}
	

}
