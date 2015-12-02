/**
 * 
 */
package CD;
import java.util.Base64;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
/**
 * @author 17ap0497
 *
 */
public class CDStack {
	
	
	private Stack<String> myStack;
	
	public CDStack(){
		myStack = new Stack<String>();
		myStack.push("Journey");
		myStack.push("Iggy Pop");
		myStack.push("Hall & Oats");
		myStack.push("Genesis");
		myStack.push("Foreign");
		myStack.push("Eagles");
		myStack.push("Deep Purple");
		myStack.push("Beatles");
		myStack.push("Aerosmith");
	}
	public String nextCD(){
		return myStack.isEmpty() ? null : myStack.peek();
	}
	public String playNextCD(){
		return myStack.pop();
	}
	public void printCD(){
		
		while(!myStack.empty()){
			System.out.println(myStack.pop());
		}
	
	}
	public void printIT(){
		
		Iterator<String> i = myStack.iterator();
		while(i.hasNext()){
			
			System.out.println(i.next());
			
		}
		
	}
	public void printFOR(){
		
		for(String s : myStack){
			
			System.out.println(s);
			
		}
		
	}
	public String printRec(String first){
		
		if(myStack.empty())
			return first+"\n";
		
	return printRec(myStack.pop()) + first + "\n";
		
		
	}
	public void reverseStack(){
		
		Stack<String> temp = new Stack<String>();
		while(!myStack.empty()){
			temp.push(myStack.pop());
		}
		myStack = temp;
		
	}
	public void convertToBinary(int n){
		
		//gg m7
		
	}

}
