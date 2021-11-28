package practice.treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthBinaryTree {

	public static void main(String[] args) {
	    TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    System.out.println("Tree Maximum Depth: " + MaximumDepthBinaryTree.findDepth(root));
	    root.left.left = new TreeNode(9);
	    root.right.left.left = new TreeNode(11);
	    System.out.println("Tree Maximum Depth: " + MaximumDepthBinaryTree.findDepth(root));
	  }

	private static int findDepth(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return 0;
		}
		int maxLevel = 0; 
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			maxLevel++;
			int queueSize = queue.size();
			for(int i=0;i<queueSize;i++) {
				TreeNode temp = queue.poll();
				if(temp.left!=null) {
					queue.offer(temp.left);
				}
				if(temp.right!=null) {
					queue.offer(temp.right);
				}
			}
			
			
		}
		return maxLevel;
	}

}
