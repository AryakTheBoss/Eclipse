/**
 * 
 */
package butthole;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 17ap0497
 *
 */
public class MorseTree extends BinarySearchTree{
	
	private TreeNode root = null;
	private Map<String,String> mm = new HashMap<String,String>();
	private Map<String,String> lm = new HashMap<String,String>();
	    protected final static String DIT = "·";
	    protected final static String DAH = "-";
	    protected final static String SPACE = " ";
	    protected final static String ENDWORD = "/ ";
	    protected final static String END = ". ";
	   private int size;
	    //String letters = "0_9O.8M Q G Z7T Y K C N X D B6/1J W P A

//R L E2- U F I3V S4H5";

	public MorseTree(){
		
		 //root = new TreeNode();
	        
	       
	        mm.put("0","-----");
	        mm.put("1","·----");
	        mm.put("2","··---");
	        mm.put("3","···--");
	        mm.put("4","····-");
	        mm.put("5","·····");
	        mm. put("6","-····");
	        mm.  put("7","--···");
	        mm. put("8","---··");
	        mm. put("9","----·");
	        
	       
	        mm. put("A","·-");
	        mm.put("B","-···");
	        mm. put("C","-·-·");
	        mm. put("D","-··");
	        mm. put("E","·");
	        mm. put("F","··-·");
	        mm. put("G","--·");
	        mm.  put("H","····");
	        mm. put("I","··");
	        mm.put("J","·---");
	        mm.put("K","-·-");
	        mm.put("L","·-··");
	        mm. put("M","--");
	        mm. put("N","-·");
	        mm.put("O","---");
	        mm.put("P","·--·");
	        mm. put("Q","--·-");
	        mm. put("R","·-·");
	        mm. put("S","···");
	        mm. put("T","-");
	        mm. put("U","··-");
	        mm. put("V","···-");
	        mm. put("W","·--");
	        mm. put("X","-··-");
	        mm. put("Y","-·--");
	        mm. put("Z","--··");
	        
	        
	        mm.put(".","·-·-·-");
	        mm. put(",","--··--");
	        mm.put("?","··--··");
	        mm.put("\'","·----·"); 
	        mm.put("/","-··-·");
	        mm. put("\"","·-··-·"); 
	        mm. put(":","---···");
	        mm.put("=","-···-");
	        mm. put("-","-····-");
	        mm. put("(","-·--·-");
	        mm. put(")","-·--·-");
	        mm. put("@","·--·-·");
	        
	        Iterator<String> i = mm.values().iterator();
	        Iterator<String> i2 = mm.keySet().iterator();
	        
	        while(i.hasNext()){
	        	
	        	lm.put(i.next(),i2.next());
	        	
	        }
		
	}
	//Auto Detect if english or morse
	public String translate(String input){
		
		String result = "";
		input = input.replace('.', '·');
		//System.out.println(input);
		if(input.startsWith("-") || input.startsWith("·")){
			
			String[] ya = input.split(ENDWORD);
			//System.out.println(Arrays.toString(ya));
			for(int i=0;i<ya.length;i++){
				String[] lettas = ya[i].split(" ");
			//	System.out.println(Arrays.toString(lettas));
				for(int j=0;j<lettas.length;j++){
					result += translateLetter(lettas[j].replaceAll(" ",""));					
				}
				result += SPACE;
			}
						
		}else{
			
			String[] ya = input.split(" ");
			for(int i=0;i<ya.length;i++){
				
				char[] lettas = ya[i].toCharArray();
				for(int j=0;j<lettas.length;j++){
					result += translateLetter((lettas[j]+"").toUpperCase());
					result += SPACE;
				}
				result += ENDWORD;
				
			}
			
		}
		
		
		return result;
		
	}
	public String translateLetter(String input){
		
	//	System.out.println(input);
		if(input.startsWith("-") || input.startsWith("·"))
			return lm.get(input);
		else
			return mm.get(input);
		
	}
	public TreeNode getRoot() {
        return root;
    } // End method getRoot()
/*	public void put (Object character, Object code) {
        String element = (String) character;
        String path = (String) code;
        String nodeKey = "";
        TreeNode cursor = getRoot();
        TreeNode temp = new TreeNode();
        
        for (int i=0; i<path.length(); i++) {
            nodeKey = path.substring(i,i+1);
            if (nodeKey.equals(DIT)) {
                if (cursor.getLeft() !=null) {
                    cursor = cursor.getLeft();
                } else {
                    cursor.setLeft(new TreeNode());
                    size += 1;
                    temp = cursor;
                    cursor = cursor.getLeft();
                    cursor.setParent(temp);
                }
            } else {
                if (cursor.getRight() != null) {
                    cursor = cursor.getRight();
                } else {
                    cursor.setRight(new TreeNode());
                    size += 1;
                    temp = cursor;
                    cursor = cursor.getRight();
                    cursor.setParent(temp);
                }
            }
        } 
        
        cursor.setValue(element);
    }*/
	 public String decode (String code) throws RuntimeException {
	        String path = (String) code;
	        String nodeKey = "";
	        TreeNode cursor = getRoot();
	       
	        for (int i=0; i<path.length(); i++) {
	            nodeKey = path.substring(i,i+1);
	            if (nodeKey.equals(DIT)) {
	                if (cursor.getLeft() != null) {
	                    cursor = cursor.getLeft();
	                } else {
	                    throw new RuntimeException("Code pattern not found.");
	                }
	            } else if (nodeKey.equals(DAH)) {
	                if (cursor.getRight() != null) {
	                    cursor = cursor.getRight();
	                } else {
	                    throw new RuntimeException("Code pattern not found. ");
	                }
	            }
	        } 
	        
	        return (String) cursor.getValue();
	    } 
}
