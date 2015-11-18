/**
 * 
 */
package algebracalsc;

/**
 * @author 17ap0497
 *
 */
public class Term implements Comparable<Term>{
	
	private int coeff = 0;
	private int powerOfX = 0;
	
	public Term(int coeff, int powerOfX){
		
		this.coeff = coeff;
		this.powerOfX = powerOfX;
		
	}
	@Override
	public String toString(){
		
		if(powerOfX == 0){
			return coeff+"";
		
	}else if(powerOfX == 1){
		return coeff+"x";
	}else if((coeff == 1 || coeff == -1) && powerOfX == 1){
	
			return coeff == -1 ? "-x":"x";
		}else if((coeff == 1 || coeff == -1) && powerOfX != 1){
			return coeff == -1 ? "-x^"+powerOfX : "x^"+powerOfX;
		}else{
			return coeff+"x^"+powerOfX;
		}
		
		
		
	}
	public boolean isZero(){
		return this.coeff == 0;
	}
	public boolean isNegative(){
		
		return (coeff < 0);
		
	}
	public int getCoeff(){
		return coeff;
	}
	public int getExp(){
		return powerOfX;
	}
	@Override
	public int compareTo(Term arg0) {
		// TODO Auto-generated method stub
		
		
		
		if(this.powerOfX < arg0.getExp())
			return 1;
		else if(this.powerOfX > arg0.getExp())
			return -1;
		else
			return 0;
		
		
		
	}
	public Term add(Term t){
		Term result = this;
		if(this.powerOfX == t.getExp()){
			result = new Term(this.coeff+t.getCoeff(),this.powerOfX);
		}
		return result;
	}
	public boolean canAdd(Term t){
		return this.powerOfX == t.getExp();
	}
	public Term multiply(Term t){
		Term result = null;
		
		result = new Term(this.coeff*t.getCoeff(),this.powerOfX+t.getExp());
		
		return result;
		
	}
	@Override
	public boolean equals(Object arg0){
		
		Term t = (Term)arg0;
		return t.getCoeff() == this.coeff && t.getExp() == this.powerOfX;
		
	}
	
	
	
	
	
	
	

}
