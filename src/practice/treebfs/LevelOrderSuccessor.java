package practice.treebfs;

import java.util.*;



class LevelOrderSuccessor {
  public static TreeNode findSuccessor(TreeNode root, int key) {

	    // TODO: Write your code here
	    if(root==null){
	      return null;
	    }
	    Queue<TreeNode> bfsQueue =  new LinkedList<TreeNode>();
	    bfsQueue.offer(root);
	    while(!bfsQueue.isEmpty()){
	      int levelSize = bfsQueue.size();
	      for(int i=0;i<levelSize;i++){
	        TreeNode node = bfsQueue.poll();
	       
	        if(node.left!=null){
	          bfsQueue.offer(node.left);
	        }
	        if(node.right!=null){
	          bfsQueue.offer(node.right);
	        }
	        
	        if(node.val == key){
		          return bfsQueue.peek();
		        }
	      }
	    }
	    return null;     
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
    if (result != null)
      System.out.println(result.val + " ");
    result = LevelOrderSuccessor.findSuccessor(root, 9);
    if (result != null)
      System.out.println(result.val + " ");
  }
}