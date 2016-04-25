/**
 * 
 */
package butthole;

/**
 * @author 17ap0497
 *
 */
public class Morse {
	
	private String letter = null;
	private String morse = null;
	
	public Morse(String input){
		
		if(input.startsWith("-") || input.startsWith(".")){
			
			morse = input;
			
		}else{
			letter = input;
		}
		
	}

}
