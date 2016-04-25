/**
 * 
 */
package butthole;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author 17ap0497
 *
 */
public class Tesrrr {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		ClubMap c = new ClubMap(new File("C:\\Users\\17ap0497\\Downloads\\rekt.txt"));
		
		c.printClubs();
		
		System.out.println("\nCALLING c.printClub(\"Math\")"+"\n\n");
		c.printClub("Math");

	}

}
