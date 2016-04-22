/**
 * 
 */
package algebracalsc;

import java.util.ListIterator;

/**
 * @author 17ap0497
 *
 */
public class AlgebraCalc {
	
	public static void main(String[] args){
		
		Polynomial p = new Polynomial();
		p.addTerm(3, 1);	
		p.addTerm(3, 1);	
		p.addTerm(-4, 7);		
		p.addTerm(8, 0);	
		p.addTerm(8, 0);	
		p.addTerm(8, 0);	
		p.addTerm(2, 2);
		p.addTerm(2, 2);
		p.addTerm(0, 2);
		//p.addTerm(1,1);
		//p.addTerm(-2,0);
		
		
		
		
		Polynomial p2 = new Polynomial();
		p2.addTerm(1, 1);
		p2.addTerm(7, 1);
		p2.addTerm(-1, 7);
		p2.addTerm(3, 0);
		p2.addTerm(2, 2);
		p2.addTerm(6, 3);
		p2.addTerm(3, 3);
		p2.addTerm(4,1);
		p2.addTerm(-4,0);
		System.out.println("Polynomial p:\n");
		p.print();		
		System.out.println("\nPolynomial p2:\n");
		p2.print();	
		System.out.println("\nDerivitive p\n");
		p.findDerivitive();
		System.out.println("\nDerivitive p2\n");
		p2.findDerivitive();
		System.out.println("\nPolynomial p+p2:\n");
		
		add(p,p2).print();
		
		
		
		System.out.println("\nPolynomial p*p2:\n");
		multiply(p,p2).print();
		
		System.out.println("\nTerm Test\n");
		Term ps = new Term(3,5);

	    Term q = new Term (2,5);

	    Term r = new Term (4,6);

	    

	System.out.println (ps.add(q));    

	System.out.println (q.multiply(r));
	
		
		
	}
	public static Polynomial add(Polynomial p, Polynomial p2){
		
				ListIterator<Term> i = p2.getIterator();
				ListIterator<Term> ii = p.getIterator();
				Polynomial result = new Polynomial();
				Term t = null;
				Term tt = null;
				while(i.hasNext()){
					t = i.next();
					result.addTerm(t.getCoeff(),t.getExp());
					
				}
				while(ii.hasNext()){
					tt = ii.next();
					result.addTerm(tt.getCoeff(),tt.getExp());
					
				}
				return result;
				
				
		
	}
	public static Polynomial multiply(Polynomial p, Polynomial p2){
		
		ListIterator<Term> pi = p.getIterator();
		ListIterator<Term> p2i = p2.getIterator();
		Polynomial result = new Polynomial();
		Term pit = null;
		Term p2it = null;
		Term temp = null;
		if(p.size() <= p2.size()){
			
			while(pi.hasNext()){
				pit = pi.next();
				p2i = p2.getIterator();
				while(p2i.hasNext()){
					p2it = p2i.next();
					temp = pit.multiply(p2it);
					result.addTerm(temp.getCoeff(), temp.getExp());
				}
				
			}
			
		}else{
			
		}
		return result;
		
		
		
	}

}
