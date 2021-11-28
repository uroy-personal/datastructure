package practice.treebfs;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode next;
	public TreeNode getNext() {
		return next;
	}
	public void setNext(TreeNode next) {
		this.next = next;
	}
	TreeNode(int x) {
		val = x;
	}
	public int getVal() {
		return val;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public void setVal(int val) {
		this.val = val;
	}
	
	
	public void printLevelOrder() {
	    TreeNode nextLevelRoot = this;
	    while (nextLevelRoot != null) {
	      TreeNode current = nextLevelRoot;
	      nextLevelRoot = null;
	      while (current != null) {
	        System.out.print(current.val + " ");
	        if (nextLevelRoot == null) {
	          if (current.left != null)
	            nextLevelRoot = current.left;
	          else if (current.right != null)
	            nextLevelRoot = current.right;
	        }
	        current = current.next;
	      }
	      System.out.println();
	    }
	  }
}