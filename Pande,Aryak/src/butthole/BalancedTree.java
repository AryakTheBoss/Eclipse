/**
 * 
 */
package butthole;

/**
 * @author 17ap0497
 *
 */
public class BalancedTree extends BinarySearchTree{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode balance(int[] arr){
		return balance(arr,0,arr.length-1);
		
	}
	private TreeNode balance(int[] arr,int start,int end){
		
		if(start > end)
			return null;
		
		int mid = start + (end - start)/2;
		TreeNode node = new TreeNode(arr[mid]);
		
		node.setLeft(balance(arr,start,mid-1));
		node.setRight(balance(arr,mid+1,end));
		return node;
		
		
		
	}

}
