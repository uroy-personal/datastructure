package practice.treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	
	public static List<List<Integer>> traverse(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    if(root==null) {
	    	return result;
	    }
	    Queue<TreeNode> bfsQueue = new LinkedList<TreeNode>();
	    bfsQueue.offer(root);
	    
	    while(!bfsQueue.isEmpty()) {
	    	
	    	int levelSize = bfsQueue.size();
	    	
	    	List<Integer> currentLevel = new ArrayList<Integer>(levelSize);
	    	
	    	for(int i=0;i<levelSize;i++) {
	    		TreeNode levelNode  = bfsQueue.poll();
	    		currentLevel.add(levelNode.getVal());
	    		
	    		if(levelNode.getLeft()!=null) {
	    			bfsQueue.offer(levelNode.getLeft());
	    		}
	    		if(levelNode.getRight()!=null) {
	    			bfsQueue.offer(levelNode.getRight());
	    		}
	    	}
	    	result.add(currentLevel);
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
		    List<List<Integer>> result = LevelOrderTraversal.traverse(root);
		    System.out.println("Level order traversal: " + result);
		  }
}
