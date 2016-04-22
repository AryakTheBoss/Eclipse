/**
 * 
 */
package algebracalsc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author 17ap0497
 *
 */
public class Polynomial {
	
	private LinkedList<Term> poly = new LinkedList<Term>();
	
	public Polynomial(){
		
		
	}
	public void addTerm(int coeff,int power){
		if(coeff == 0){
			return;
		}
		Term t = new Term(coeff,power);
		Term t2=null;
		ListIterator<Term> i = this.getIterator();
		while(i.hasNext()){
			t2=i.next();
			if(power == t2.getExp()){
				i.remove();
				
				t = new Term(coeff+t2.getCoeff(),t2.getExp());
				
				break;
			}
		}
		if(!t.isZero())
		poly.addLast(t);
		
		Collections.sort(poly);
		//simplfy();
		
	}

	public int size(){
		return poly.size();
	}
	
	public boolean hasElement(Term t){
		
		ListIterator<Term> i = this.getIterator();
		while(i.hasNext()){
			if(i.next().equals(t)){
				return true;
			}
		}
		return false;
		
	}
	public void print(){
		
		ListIterator<Term> t = poly.listIterator();
		System.out.print(t.next());
		Term tt;
		while(t.hasNext()){
			tt=t.next();
			if(tt.isNegative()){
				System.out.print(tt);
			}else{
				System.out.print("+"+tt);
			}
			
		}
		System.out.println();
		
	}
	
	public ListIterator<Term> getIterator(){
		return poly.listIterator();
	}
	public ListIterator<Term> getIterator(int index){
		return poly.listIterator(index);
	}
	public void findDerivitive(){
		
		ListIterator<Term> t = poly.listIterator();
		Polynomial der = new Polynomial();
		Term tt;
		
		while(t.hasNext()){
			tt = t.next();
			if(tt.getExp() != 0)
			der.addTerm(tt.getCoeff()*tt.getExp(), tt.getExp()-1);
			
		}
		der.print();
		
		
	}
	

}
