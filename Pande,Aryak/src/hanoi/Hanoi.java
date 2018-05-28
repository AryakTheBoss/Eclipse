package hanoi;

public class Hanoi {
	
	private static int moves = 1;
	
	
	public static String hanoi(int n,int fromPeg,int toPeg){
		
		int helpPeg;
	   	 String Sol1, Sol2, MyStep, mySol;
	   	 
		if(n==1){
			
			return fromPeg + " -> " + toPeg+"\n";
			
		}else{
			helpPeg = 6 - fromPeg - toPeg;
			
			Sol1 = hanoi(n-1,fromPeg,helpPeg);
			moves++;
			
			MyStep = fromPeg + " -> " + toPeg + "\n";    
            
	   	    Sol2 = hanoi(n-1, helpPeg, toPeg); 
	   	    moves++;

		    mySol = Sol1 + MyStep + Sol2; 
			
		}
		
		return mySol;
		
		
	}
	public static void main(String[] args){
		
		int n = 15;
	    
	   	 String stepsToSolution;
	    
	   	 stepsToSolution = hanoi(n, 1, 3);
	    
	   	 System.out.println(stepsToSolution);
	 	 System.out.println("Moves: "+moves);
	}

}
