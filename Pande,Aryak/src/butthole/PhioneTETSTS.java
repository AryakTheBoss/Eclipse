/**
 * 
 */
package butthole;

/**
 * @author 17ap0497
 *
 */
public class PhioneTETSTS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PhoneBook lol = new PhoneBook();
		
		lol.display();
		System.out.println("\n\n"+"GET CAPACITY, GET SIZE"+" "+lol.getCapacity()+" , "+lol.getSize());
		System.out.println("\n\n"+"Number of Nulls = "+lol.getNumberOfNulls());
		System.out.println("\nLongest List = "+lol.getLongestList()+"\n\n");
		System.out.println("Meda num: "+lol.lookup("Meda"));
		System.out.println("Gomez num: "+lol.lookup("Gomez"));
		System.out.println("Halim num: "+lol.lookup("Halim"));
		System.out.println("Evers num: "+lol.lookup("Evers"));
		System.out.println("DumbGuy num: "+lol.lookup("DumbGuy"));

	}

}
