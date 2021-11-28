package practice.treebfs;

import java.util.*;



  // level order traversal using 'next' pointer



class ConnectLevelOrderSiblings {
  public static void connect(TreeNode root) {
   
	  TreeNode currentNode =root;
	  TreeNode previousNode =null;
	  Queue<TreeNode> bfsQueue = new LinkedList<TreeNode>();
	  
	  bfsQueue.offer(root);
	  
	  while(!bfsQueue.isEmpty()) {
		  int levelSize = bfsQueue.size();
		  for(int i=0;i<levelSize;i++) {
			  currentNode = bfsQueue.poll();
			  if(previousNode!=null) {
				  previousNode.next = currentNode;
			  }
			  previousNode = currentNode;
			  if(currentNode.left!=null) {
				  bfsQueue.offer(currentNode.left);
			  }
			  if(currentNode.right!=null) {
				  bfsQueue.offer(currentNode.right);
			  }
			  
		  }
	  }
	  
	  
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    ConnectLevelOrderSiblings.connect(root);
    System.out.println("Level order traversal using 'next' pointer: ");
    root.printLevelOrder();
  }
}