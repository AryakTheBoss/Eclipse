package butthole;
import static java.lang.System.*;

public class BSTreeRunner
{
   public static void main( String args[] )
   {
 		//add test cases here
 		BinarySearchTree bst = new BinarySearchTree();
 		//70 80 85 90 98 100 120
 		bst.add(90);
 		bst.add(100);
 		bst.add(80);
 		bst.add(98);
 		bst.add(85);
 		bst.add(120);
 		bst.add(70);
 		out.println("IN ORDER:");
 		bst.inOrder();
 		out.println("PRE ORDER:");
 		bst.preOrder();
 		out.println("POST ORDER:");
 		bst.postOrder();
 		out.println("REV ORDER:");
 		bst.revOrder();
 		out.println("NUM LEVELS: "+bst.getNumLevels());
 		out.println("NUM LEAVES: "+bst.getNumLeaves());
 		out.println("NUM NODES: "+bst.getNumNodes());
 		out.println("WIDTH: "+bst.getWidth());
 		out.println("HEIGHT: "+bst.getHeight());
 		out.println("Tree As String: "+bst);
 		out.println("isFull: "+bst.isFull());
 		
 		out.println("SEARCH FOR 100: "+bst.search(100));
 		out.println("SEARCH FOR 500: "+bst.search(500));
 		out.println("MAX: "+bst.max());
 		out.println("MIN: "+bst.min());
 		out.println("LEVEL ORDER: ");
 		bst.printTree();
 		
 		bst.remove(100);
 		out.println("\nAfter Removing 100: ");
 		bst.levelOrder();
 		
 		
 
   }
}