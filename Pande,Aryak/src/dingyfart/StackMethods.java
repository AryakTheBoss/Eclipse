/**
 * 
 */
package dingyfart;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @author 17ap0497
 *
 */
public class StackMethods {

	/**
	 * @param args
	 */
	public static double getAverage(Stack<Integer> one){
		int kl = 0;
		int siz = one.size();
		for(int i=0;i<one.size();i++){
			
			kl += one.pop();
			
		}
		return kl/siz;
	}

	public static Stack<String> alternateStack (Stack<String>  one, Stack<String> two){
		
		Stack<String> alpha = new Stack<String>();
		Collections.reverse(one);
		Collections.reverse(two);
		if(one.size() == two.size()){
		for(int i=0;i<one.size()*2;i++){
			if(i % 2 == 0)
				alpha.push(one.pop());
			else
				alpha.push(two.pop());
			
		}
		}else{
			int cc = one.size()+two.size();
			for(int i=0;i<cc;i++){
				if(one.empty()){
					//System.out.println("guck");
					alpha.push(two.pop());
				}else if(two.empty()){
					//System.out.println("sheet");
					alpha.push(one.pop());					
				}else{
					if(i % 2 == 0){
						alpha.push(one.pop());
					//System.out.println("alt");
					}else{
						alpha.push(two.pop());
					//	System.out.println("alt2");
					}
				}
			}
		}
		//Collections.reverse(alpha);
		return alpha;
	}

	        //Good Question: For alternating stacks, are they the same size??…Do they have to be??? 

	public static Stack<String> removeEveryOther(Stack<String> one) {
		int guck = one.size();
		Stack<String> betas = new Stack<String>();
		Collections.reverse(one);
		for(int i=0;i < guck;i++){
			if(i % 2 != 0){
				
				betas.push(one.remove(i));
				System.out.println("alt2");
			}
			
		}
		return betas;
	}

	      //Removes every other element in the stack – but the order of others shouldn’t change. 

	public  static void display(Stack<String> one){
		System.out.println(one);
	}

	      //We want to print in the order that it comes off the stack

	

	public static void main(String[] args){

	Stack<Integer> a = new Stack<Integer>(); 

	a.push(5); 

	a.push(2); 

	a.push(7);

	Stack<String> b = new Stack<String>(); 

	b.push("one"); 

	b.push("two");

	Stack<String> c = new Stack<String>();

	             c.push("three");

	             c.push("four");

	             c.push("five");

	             display(alternateStack(b,c));

	System.out.println();

	Stack<String> d = new Stack<String>(); 

	d.push("six"); 

	d.push("seven"); 

	d.push("eight"); 

	d.push("nine"); 

	d.push("ten"); 

	display(removeEveryOther(d));
	System.out.println(getAverage(a));
	}
	
}
