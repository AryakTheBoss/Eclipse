/**
 * 
 */
package rraysumting;

import java.util.Random;

/**
 * @author 17ap0497
 *
 */
public class ArraySum {
	
	private int[][] numbers = new int[10][10];
	private Random r = new Random();
	private final int[] chance = {-1,-1,-1,0,0,0,0,0,0,0};
	//30% chance that -1 will be picked so if -1 is picked it will be a * else itl be a number
	
	public ArraySum(){
		
		fillArray(numbers,0,0);
	
	}
	
	private int[][] fillArray(int[][] nums,int row,int col){
		if(col >= nums[0].length){
			row++;
			col = 0;
			if(row >= nums.length){
				return nums;
			}
			
		}
		if(chance[r.nextInt(chance.length)] == 0)
			nums[row][col] = r.nextInt(9)+1;
		else
			nums[row][col] = -1;
		
		return fillArray(nums,row,col+1);
		
		
	}
	public int sumArray(){
		int sum =0;
		for(int i=0;i<numbers.length;i++){
			for(int j=0;j<numbers[0].length;j++){
				if(numbers[i][j] != -1)					
				sum += numbers[i][j];
			}
		}
		return sum;
		
	}
	public void printArray(){
		
		for(int i=0;i<numbers.length;i++){
			for(int j=0;j<numbers[0].length;j++){
				if(numbers[i][j] == -1)
					System.out.print("* ");
				else
				System.out.print(numbers[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
