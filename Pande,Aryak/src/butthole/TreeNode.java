package butthole;
public class TreeNode implements Treeable
{
	private Comparable treeNodeValue;
	private TreeNode leftTreeNode;
	private TreeNode rightTreeNode;
	private TreeNode parent;

	public TreeNode( )
	{
		treeNodeValue = null;
		leftTreeNode = null;
		rightTreeNode = null;
		parent = null;
	}

	public TreeNode(Comparable value)
	{
		treeNodeValue = value;
		leftTreeNode = null;
		rightTreeNode = null;
		parent = null;
	}

	public TreeNode(Comparable value, TreeNode left, TreeNode right)
	{
		treeNodeValue = value;
		leftTreeNode = left;
		rightTreeNode = right;
		parent = null;
	}

	public Comparable getValue()
	{
		return treeNodeValue;
	}
	public TreeNode getParent(){
		return parent;
	}
	 public void setParent (TreeNode n) {
         parent = n;
     } 
	public TreeNode getLeft()
	{
		return leftTreeNode;
	}

	public TreeNode getRight()
	{
		return rightTreeNode;
	}

	public void setValue(Comparable value)
	{
		treeNodeValue = value;
	}

	public void setLeft(Treeable left)
	{
		leftTreeNode = (TreeNode)left;
	}

	public void setRight(Treeable right)
	{
		rightTreeNode = (TreeNode)right;
	}
}