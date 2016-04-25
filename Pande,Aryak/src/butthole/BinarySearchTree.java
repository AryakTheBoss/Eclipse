package butthole;
import static java.lang.System.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree
{
	private TreeNode root;

	public BinarySearchTree()
	{
		root = null;
	}

	public void add(Comparable val)
	{
		root = add(val, root);
	}
public void setRoot(TreeNode rooot){
	root = rooot;
}
	private TreeNode add(Comparable val, TreeNode tree)
	{
	   if(tree == null){
			tree = new TreeNode(val,null,null);
			return tree;
	   }
		
		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);
		
		
		if(dirTest <= 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if(dirTest > 0)
			tree.setRight(add(val, tree.getRight()));
		
		return tree;
	}

   public void inOrder()
	{
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree)
	{
		if (tree != null){
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	//add preOrder, postOrder, and revOrder
	public void preOrder(){
		printPreOrderRec(root);
		System.out.println("\n\n");
	}
	private void printPreOrderRec(TreeNode currRoot) {
		
		  if (currRoot != null) {
		
			  System.out.print(currRoot.getValue() + " ");
				
			  printPreOrderRec(currRoot.getLeft());
			
			  printPreOrderRec(currRoot.getRight());
		
		  }
		
		 
		
		}

	
	
	public void postOrder(){
		
		 printPostOrderRec(root);
		 System.out.println("\n\n");
		
	}
	
	private void printPostOrderRec(TreeNode currRoot) {
		
		  if (currRoot == null) {
		
		    return;
		
		  }
		
		  printPostOrderRec(currRoot.getLeft());
		
		  printPostOrderRec(currRoot.getRight());
		
		  System.out.print(currRoot.getValue() + " ");
		
		 
		
		}


public void revOrder(){
	
	printRevOrder(root);
	System.out.println("\n\n");
	
}
private void printRevOrder(TreeNode root){
	if (root != null){
		
		printRevOrder(root.getRight());
		System.out.print(root.getValue() + " ");
		printRevOrder(root.getLeft());
		
	}
}

	public int getNumLevels()
	{
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree)
	{
		if(tree==null)
			return 0;
		else if(getNumLevels(tree.getLeft())>getNumLevels(tree.getRight()))
			return 1+getNumLevels(tree.getLeft());
		else
			return 1+getNumLevels(tree.getRight());
	}

public int getNumLeaves(){
	
	return getNumLeaves(root);
	
}
	private int getNumLeaves(TreeNode node){
		  if( node == null )
		    return 0;
		  if( node.getLeft() == null && node.getRight() == null ) {
		    return 1;
		  } else {
		    return getNumLeaves(node.getLeft()) + getNumLeaves(node.getRight());
		  }
		}
	public int getHeight(){
		
		return findHeight(root);
		
	}
	private int findHeight(TreeNode aNode)
	{
	    return getNumLevels(aNode)-1;
	}
	public int getWidth(){
		return findMaxWidth(root);
	}
	private int findMaxWidth(TreeNode root){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int levelNodes =0;
		int maxWidth = 0;
		if(root==null) return 0;
		q.add(root);

		while(!q.isEmpty()){
			levelNodes = q.size();
			if(levelNodes>maxWidth){
				maxWidth = levelNodes;
			}
			while(levelNodes>0){
				TreeNode n = (TreeNode)q.remove();
				if(n.getLeft()!=null) q.add(n.getLeft());
				if(n.getRight()!=null) q.add(n.getRight());
				levelNodes--;
			}
		}
		return maxWidth;
	}
	public int getNumNodes(){
		return numNodes(root);
	}
	private int numNodes(TreeNode current) {   
		 
		  if (current == null) return 0;
		 
		  return 1 + numNodes(current.getLeft()) + numNodes(current.getRight());
		}
	public boolean isFull(){
		return isFull(root);
	}
	private boolean isFull(TreeNode root)
	
	{

	    if (root!=null)
	    {
	        if(root.getRight() == null && root.getLeft() == null)
	        {
	             return true;
	        }
	        if ((root.getRight() != null && root.getLeft() != null))
	        {
	            return isFull(root.getLeft())&&isFull(root.getLeft());
	        }
	    }
	    return false;
	}
	public TreeNode search(Comparable val){
		
		return locate(val,root);
		
	}
	private TreeNode locate(Comparable p, TreeNode famTree)
	{
	    TreeNode result = null;
	    if (famTree == null)
	        return null;
	    if (famTree.getValue().equals(p))
	        return famTree;
	    if (famTree.getLeft() != null)
	        result = locate(p,famTree.getLeft());
	    if (result == null)
	        result = locate(p,famTree.getRight());
	    return result;

	}
	public void levelOrder(){
		levelOrderTraversal(root);
	}
	private void levelOrderTraversal(TreeNode startNode) {  
		  Queue<TreeNode> queue=new LinkedList<TreeNode>();  
		  queue.add(startNode);  
		  while(!queue.isEmpty())  
		  {  
		   TreeNode tempNode=queue.poll();  
		   System.out.printf("%d ",tempNode.getValue());  
		   if(tempNode.getLeft()!=null)  
		    queue.add(tempNode.getLeft());  
		   if(tempNode.getRight()!=null)  
		    queue.add(tempNode.getRight());  
		  }  
		 }  
	public void printTree(){
		printTree(root);
	}
	

	private void printTree(TreeNode tmpRoot) {

        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

        currentLevel.add(tmpRoot);

        while (!currentLevel.isEmpty()) {
            Iterator<TreeNode> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                TreeNode currentNode = iter.next();
                if (currentNode.getLeft() != null) {
                    nextLevel.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    nextLevel.add(currentNode.getRight());
                }
                System.out.print(currentNode.getValue() + " ");
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();

        }

    }

		public Comparable max(){
			return getMax(root);
		}
	
	private Comparable getMax(TreeNode root) { 
		   if(root.getRight() == null) {
		       return root.getValue();
		   } else {
		       return getMax(root.getRight());
		   }
		}
	public Comparable min(){
		return min(root).getValue();
	}
	 private TreeNode min(TreeNode x) { 
	        if (x.getLeft() == null) return x; 
	        else                return min(x.getLeft());
	    } 
	
	
	
	
	
	 public void remove(Comparable val){

	 root = remove(val, root); 
	 }

	 private TreeNode remove(Comparable val, TreeNode tree)
	 {
	 if(tree != null){

	 int dirTest = val.compareTo(tree.getValue());
	 
	 if (dirTest < 0)
	 tree.setLeft(remove(val, tree.getLeft()));
	 else if (dirTest > 0)
	 tree.setRight(remove(val, tree.getRight()));
	 else{

	 if(tree.getRight()==null){

	 tree = tree.getLeft();

	 }else{

	 TreeNode successor = min(tree.getRight());
	 tree.setValue(successor.getValue());
	 tree.setRight(remove(successor.getValue(), tree.getRight()));
	 }
	 }
	 }
	 return tree;
	 }
	 

	
	 
	 public String toString() {
		 
	        return toString("",root);
	    }

	 private String toString(String prefix, TreeNode node)
	 {
		 if (node == null) return " ";
	      String string = " "+prefix + node.getValue().toString();
	      if (node.getLeft() != null)
		         string = string +  toString(" " + prefix, node.getLeft());
	      if (node.getRight() != null)
	         string = toString(" " + prefix, node.getRight()) +  string;
	      
	      return string;
	 }
	
}