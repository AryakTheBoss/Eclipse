/**
 * 
 */
package butthole;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author 17ap0497
 *
 */
public class ClubMap {
	
	private Map<String, TreeSet<Student>> clubs = new HashMap<String, TreeSet<Student>>();
	
	public ClubMap(File f) throws FileNotFoundException{
		
		Scanner s = new Scanner(f);
		while(s.hasNextLine()){
			String ss = s.nextLine().replaceAll("\\s+"," ");
			String[] kek = ss.split(" ");
			try{
			add(new Student(kek[1].replace(" ", ""),kek[0].replace(" ", ""),kek[2].replace(" ", "")),kek[3].replace(" ", ""));
			}catch(ArrayIndexOutOfBoundsException a){
				System.out.println(Arrays.toString(kek));
			}
		}
		
	}
	public void add(Student s, String club){
		
		if(clubs.get(club) == null){
			clubs.put(club, new TreeSet<Student>());
			clubs.get(club).add(s);
		}else{
			clubs.get(club).add(s);
		}
		
	}
	
	public void printClubs(){
		
		Iterator<String> i = clubs.keySet().iterator();	
		Iterator<Student> r;
		while(i.hasNext()){
			String club = i.next();
			r = clubs.get(club).iterator();
			System.out.println("\nStudents in "+club+":\n\n");
			while(r.hasNext())
			System.out.println(r.next().toString());
			
		}
		
	}
	
	public void printClub(String club){
		
		Iterator<Student> r=clubs.get(club).iterator();;
		System.out.println("\nStudents in "+club+":\n\n");
		while(r.hasNext())
		System.out.println(r.next().toString());
	}

}
