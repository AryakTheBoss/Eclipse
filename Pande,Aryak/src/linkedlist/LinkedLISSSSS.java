package linkedlist;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedLISSSSS {

	public static void main(String[] args){
		
LinkedList<String> ll = new LinkedList<String>();
		
		ll.addLast("Aditya");
		ll.addFirst("Viren");
		ll.addLast("Dan");
		ll.addFirst("Jason");
		ll.addFirst("Vishal");
		ll.addFirst("Koushik");
		ll.addLast("Teja");
		ll.addLast("Priya");
		
		
		
		System.out.println(ll);
		System.out.println("\n***************REVERSE***************\n");
		reverse(ll);
		System.out.println("\n***************DUPLICATE***************\n");
		duplicate(ll);
		System.out.println("\n***************REPEAT***************\n");
		repeat(ll);
		System.out.println("\n***************DELETE***************\n");
		delete(ll,"Teja");
		System.out.println("\n***************INSERT***************\n");
		insert(ll,"Matt");
	}
	public static void reverse(LinkedList<String> ll){

		
		ListIterator<String> i = ll.listIterator(ll.size());
		
		while(i.hasPrevious())
		System.out.println(i.previous());
	}
	public static void duplicate(LinkedList<String> ll){
		
ListIterator<String> i = ll.listIterator();
		
		while(i.hasNext()){
		System.out.println(i.next()+"\n"+i.previous());
		i.next();
		}
		
	}
	public static void repeat(LinkedList<String> ll){
		
		ListIterator<String> i = ll.listIterator();
		while(i.hasNext())
			System.out.println(i.next());			
			i = ll.listIterator();
		while(i.hasNext())
			System.out.println(i.next());
		
		
		
	}
	public static void delete(LinkedList<String> ll,String searchFor){
		
		ListIterator<String> i = ll.listIterator();
		while(i.hasNext())
			if(i.next().equals(searchFor))
				i.remove();
		
		System.out.println(ll);
		
	}
	public static void insert(LinkedList<String> ll, String toAdd){
		
		ll.addLast(toAdd);
		Collections.sort(ll);
		
		System.out.println(ll);
		
	}
}
