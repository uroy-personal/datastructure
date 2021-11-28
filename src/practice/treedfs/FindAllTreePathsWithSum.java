package practice.treedfs;
import java.util.*;

class FindAllTreePathsWithSum {
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
    
	List<List<Integer>> allPaths = new ArrayList<>();
    // TODO: Write your code here
    
    List<Integer> currentPath = new ArrayList<>();
    
    findAllPathsRecursive(root, sum,currentPath, allPaths );
    
    return allPaths;
  }
  
  public static void findAllPathsRecursive(TreeNode currentNode, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
	  if(currentNode==null) {
		  return;
	  }
	  
	  currentPath.add(currentNode.val);
	  
	  if(currentNode.val==sum && currentNode.left == null && currentNode.right==null) {
	    allPaths.add(new ArrayList<Integer>(currentPath));
	  }
	  
	  findAllPathsRecursive(currentNode.left, sum-currentNode.val, currentPath, allPaths);
	  
	  findAllPathsRecursive(currentNode.right, sum-currentNode.val, currentPath, allPaths);
	  
	  // Backtracking to remove the last addition of currentNode
	  currentPath.remove(currentPath.size()-1);
	  
	  
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    int sum = 23;
    List<List<Integer>> result = FindAllTreePathsWithSum.findPaths(root, sum);
    System.out.println("Tree paths with sum " + sum + ": " + result);
  }
}