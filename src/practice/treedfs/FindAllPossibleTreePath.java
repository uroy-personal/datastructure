package practice.treedfs;
import java.util.*;

class FindAllPossibleTreePath {
  public static List<List<Integer>> findPaths(TreeNode root) {
    
	List<List<Integer>> allPaths = new ArrayList<>();
    // TODO: Write your code here
    
    List<Integer> currentPath = new ArrayList<>();
    
    findAllPathsRecursive(root, currentPath, allPaths );
    
    return allPaths;
  }
  
  public static void findAllPathsRecursive(TreeNode currentNode,  List<Integer> currentPath, List<List<Integer>> allPaths) {
	  if(currentNode==null) {
		  return;
	  }
	  
	  currentPath.add(currentNode.val);
	  
	  if(currentNode.left == null && currentNode.right==null) {
	    allPaths.add(new ArrayList<Integer>(currentPath));
	  }
	  
	  findAllPathsRecursive(currentNode.left,  currentPath, allPaths);
	  
	  findAllPathsRecursive(currentNode.right,  currentPath, allPaths);
	  
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
    
    List<List<Integer>> result = FindAllPossibleTreePath.findPaths(root);
    System.out.println("Tree paths : " + result);
  }
}