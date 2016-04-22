package dingyfart;// PalinLins.java

import java.util.Collections;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;

public class PalinList
{
	private Queue<String> queue;
	private Stack<String> stack;

	public PalinList()
	{
		setList("");
	}

	public PalinList(String list)
	{
		setList(list);		
	}

	public void setList(String list)
	{
		queue = new LinkedList<String>();
		stack = new Stack<String>();
		String[] betas = list.split(" ");
		for(int i=0;i<betas.length;i++){
			stack.push(betas[i]);
		}
		for(int i=0;i<betas.length;i++){
			queue.offer(betas[i]);
		}
		Collections.reverse(stack); 
	}

	public boolean isPalin()
	{
		
		return queue.equals(stack);
	
	}

	public String toString(){
		
		return queue.toString();
		
	}

	//write a toString method
}