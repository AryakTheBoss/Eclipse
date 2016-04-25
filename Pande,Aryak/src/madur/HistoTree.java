package madur;
import static java.lang.System.*;
import butthole.TreeNode;

public class HistoTree
{
   private HistoNode root;

	public HistoTree( )
	{
		root = null;
	}

	public void addData(Comparable data)
	{
		root = add(data,root);
	}

	private HistoNode add(Comparable data, HistoNode tree)
	{
		
		if(tree == null){
			tree = new HistoNode(data,1,null,null);
			return tree;
	   }
		
		Comparable treeValue = tree.getData();
		int dirTest = data.compareTo(treeValue);
		
		
		
		 if(dirTest > 0)
			tree.setLeft(add(data, tree.getLeft()));
		else if(dirTest < 0)
			tree.setRight(add(data, tree.getRight()));
		else if(dirTest == 0){
				
				
					tree.setDataCount(tree.getDataCount()+1);
				//return tree;
			}
		 
		 
		
		return tree;
	}

	public HistoNode search(Comparable data)
	{
		return search(data,root);
	}

	private HistoNode search(Comparable data, HistoNode famTree)
	{
		HistoNode result = null;
	    if (famTree == null)
	        return null;
	    if (famTree.getData().equals(data))
	        return famTree;
	    if (famTree.getLeft() != null)
	        result = search(data,famTree.getLeft());
	    if (result == null)
	        result = search(data,famTree.getRight());
	    return result;
	}

	public String toString()
	{
		return toString("",root);
	}

	private String toString(String prefix,HistoNode node)
	{
		if (node == null) return " ";
	      String string = " "+prefix + node.getData().toString()+"-"+node.getDataCount();
	      if (node.getLeft() != null)
		         string = string +  toString(" " + prefix, node.getLeft());
	      if (node.getRight() != null)
	         string = toString(" " + prefix, node.getRight()) +  string;
	      
	      return string;
	}
}