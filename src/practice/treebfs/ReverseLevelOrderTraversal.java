package practice.treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {

		  public static List<List<Integer>> traverse(TreeNode root) {
		    
			List<List<Integer>> result = new LinkedList<List<Integer>>();
			
			if(root==null) {
				return 	result;
		    }
		    
			Queue<TreeNode> bfsQueue =  new LinkedList<TreeNode>();

			bfsQueue.offer(root);
			
			while(!bfsQueue.isEmpty()) {
				int levelSize = bfsQueue.size();
				List<Integer> levelList = new ArrayList<Integer>();
				for(int i=0;i<levelSize;i++) {
					TreeNode treeNode =  bfsQueue.poll();
					levelList.add(treeNode.getVal());
					if(treeNode.getLeft()!=null) {
						bfsQueue.offer(treeNode.getLeft());
					}
					if(treeNode.getRight()!=null) {
						bfsQueue.offer(treeNode.getRight());
					}
				}
				result.add(0,levelList);
			}
			
		    return result;
		  }

		  public static void main(String[] args) {
		    TreeNode root = new TreeNode(12);
		    root.left = new TreeNode(7);
		    root.right = new TreeNode(1);
		    root.left.left = new TreeNode(9);
		    root.right.left = new TreeNode(10);
		    root.right.right = new TreeNode(5);
		    List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
		    System.out.println("Reverse level order traversal: " + result);
		  }
	
}
