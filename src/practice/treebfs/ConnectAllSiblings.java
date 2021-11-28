package practice.treebfs;

import java.util.*;



class ConnectAllSiblings {
  public static void connect(TreeNode root) {
    // TODO: Write your code here
	  if(root == null) {
		  return;
	  }
	  Queue<TreeNode> bfsQueue =  new LinkedList<TreeNode>();
	  bfsQueue.offer(root);
	  TreeNode currentNode = null;
	  TreeNode previousNode = null;
	  while(!bfsQueue.isEmpty()) {
		  
		  
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

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    ConnectAllSiblings.connect(root);

    // level order traversal using 'next' pointer
    TreeNode current = root;
    System.out.println("Traversal using 'next' pointer: ");
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }
}