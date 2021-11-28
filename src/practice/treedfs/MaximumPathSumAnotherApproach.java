package practice.treedfs;



	public class MaximumPathSumAnotherApproach {

	  private static int globalMaximumSum;

	  public static int findMaximumPathSum(TreeNode root) {
	    globalMaximumSum = Integer.MIN_VALUE;
	    postOrderTraversal(root);
	    return globalMaximumSum;
	  }

	  private static int postOrderTraversal(TreeNode currentNode) {
		if(currentNode==null) return 0;
		int maxPathSumLeft = postOrderTraversal(currentNode.left);
		int maxPathSumRight = postOrderTraversal(currentNode.right);
		
		
		maxPathSumLeft = Math.max(maxPathSumLeft, 0);
		maxPathSumRight = Math.max(maxPathSumRight, 0);
		
		int localMax = Math.max(maxPathSumLeft, maxPathSumRight)+currentNode.val;
		
		globalMaximumSum =  Math.max(globalMaximumSum, localMax);
		return Math.max(maxPathSumLeft, maxPathSumRight)+currentNode.val;
		
	  }

	  public static void main(String[] args) {
	    TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    System.out.println("Maximum Path Sum: " + MaximumPathSumAnotherApproach.findMaximumPathSum(root));
	    
	    root.left.left = new TreeNode(1);
	    root.left.right = new TreeNode(3);
	    root.right.left = new TreeNode(5);
	    root.right.right = new TreeNode(6);
	    root.right.left.left = new TreeNode(7);
	    root.right.left.right = new TreeNode(8);
	    root.right.right.left = new TreeNode(9);
	    System.out.println("Maximum Path Sum: " + MaximumPathSumAnotherApproach.findMaximumPathSum(root));
	    
	    root = new TreeNode(-1);
	    root.left = new TreeNode(-3);
	    System.out.println("Maximum Path Sum: " + MaximumPathSumAnotherApproach.findMaximumPathSum(root));
	  }
	}