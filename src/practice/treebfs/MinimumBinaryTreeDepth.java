package practice.treebfs;

import java.util.*;


class MinimumBinaryTreeDepth {
  public static int findDepth(TreeNode root) {
    // TODO: Write your code here
    if(root ==  null){
      return -1;
    }
    int minimumDepth = 0;
    Queue<TreeNode> bfsQueue =  new LinkedList<TreeNode>();
    bfsQueue.offer(root);
    while(!bfsQueue.isEmpty()){
      minimumDepth++;
      int levelSize = bfsQueue.size();

      for(int i=0;i<levelSize;i++){
          TreeNode node = bfsQueue.poll();
      
          if(node.right==null && node.left==null){
            return minimumDepth;
          }

          if(node.left!=null){
            bfsQueue.offer(node.left);
          }
          
          if(node.right!=null ){
            bfsQueue.offer(node.right);
          }
      }
      
    }
    return -1;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    root.left.left = new TreeNode(9);
    root.right.left.left = new TreeNode(11);
    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
  }
}