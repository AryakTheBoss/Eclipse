/**
 * 
 */
package sample;

/**
 * @author UnityBoss
 *
 */
public class ArrayTEST {

	/**
	 * @param args
	 * @throws ArrayFullException 
	 */
	public static void main(String[] args) throws ArrayFullException {
		//TODO Demo ArrayTools and ArrayOrg
		
		System.out.println(toCharArray("dingo",true).toSTR(false));
        

	}
	
	public static ArrayUtil<Character> toCharArray(String key,boolean showSpaces) throws ArrayFullException{
		System.out.println(key.length());
		ArrayUtil<Character> ao = new ArrayUtil<Character>();
		ao.init(key.length()); 
		
		if(showSpaces == false){
		for(int i=0;i<key.length();i++){
			if(key.charAt(i) != ' '){
			ao.add(key.charAt(i));  
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		}else{
			for(int i=0;i<key.length();i++){
				
				ao.add(key.charAt(i));  
				
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}	
			
			
		}
		
		return ao;
		
	}

}
