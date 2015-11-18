/**
 * 
 */
package queen;

/**
 * @author 17ap0497
 *
 */
//Aryak and Rohan
public class Queen {
	
	
	private int[] x;
	private int count = 0;
	private int rec = 0;

    public Queen(int n) {
        x = new int[n];
    }

    public boolean isSafe(int r, int c) {
        //chek if a queen isa safe
        for (int i = 0; i < r; i++) {
            if ( x[i] == c || (i - r) == (x[i] - c) || (i - r) == (c - x[i]) ) 
            {
                return false;
            }
        }
        return true;
    }

    public void printBoard(int[] x) {
        int n = x.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (x[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

   private void placeRecursive(int r, int n) {
        rec++;
        for (int c = 0; c < n; c++) {
            if (isSafe(r, c)) {
                x[r] = c;
                if (r == n - 1) {
                    printBoard(x);
                    count++;
                } else {
                    placeRecursive(r + 1, n);
                }
            }
        }
    }
   public int getCount(){
	   
	   return count;
	   
   }
   public int getRekt(){
	   
	   return rec;
	   
   }

    public void placeQueens() {
        placeRecursive(0, x.length);
    }

    public static void main(String args[]) {
        Queen q = new Queen(8);
        q.placeQueens();
        System.out.println("The amount of valid solutions: "+q.getCount());
        System.out.println("The amount of Recursive Calls: "+q.getRekt());
     
    }
} 

	

