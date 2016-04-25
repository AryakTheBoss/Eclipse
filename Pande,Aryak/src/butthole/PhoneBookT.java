/**
 * 
 */
package butthole;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author 17ap0497
 *
 */
public class PhoneBookT{

	private PhoneBook pb = new PhoneBook();
	private BinarySearchTree bst = new BinarySearchTree();
	
	public PhoneBookT(){
		
		try{
			load();
		}catch(FileNotFoundException f){
			f.printStackTrace();
		}

	}
	public void display(){
		
		bst.printTree();
		
	}
	public String lookupNumber(String lookFor){
		
		String a = pb.lookup(lookFor);
		a = a.substring(0, a.indexOf(" "));
		return a;
		
		
	}
	public String reverseLookup(String lookFor){
		
		String a = pb.lookup(lookFor);
		a=a.substring(a.indexOf(" "));
		return a;
		
	}
	public void delete(String delte){
		
		bst.remove(reverseLookup(delte));
		
		
	}
public void load() throws FileNotFoundException{
		
		Scanner s = new Scanner(new File("C:\\Users\\17ap0497\\Downloads\\phonek.txt"));
		String ss;
		String[] kek;
		while(s.hasNextLine()){
			
			ss = s.nextLine().replaceAll("\\s+"," ");
			kek = ss.split(" ");
			bst.add(new PhoneEntry(kek[0],kek[1]));
			
		}
		s.close();
		
	}
	
}
