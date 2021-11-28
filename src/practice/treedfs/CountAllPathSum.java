package practice.treedfs;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;



class CountAllPathSum {
	public static int countPaths(TreeNode root, int S) {
	    // TODO: Write your code here
		List<Integer> currentPath = new LinkedList<Integer>();
		
	    return countPathsRecursive(root, currentPath, S);
	  }
	public static int countPathsRecursive(TreeNode root, List<Integer> currentPath, int S) {
	    // TODO: Write your code here
		if(root==null) {
			return 0;
		}
		int pathCount=0; 
		int pathSum=0;
		currentPath.add(root.val);
		ListIterator<Integer> iterator = currentPath.listIterator(currentPath.size());
		while(iterator.hasPrevious()){
			pathSum+=iterator.previous();
			if(pathSum==S) {
				pathCount++;
			}
		}
		pathCount+=countPathsRecursive(root.left, currentPath, S);
		
		pathCount+=countPathsRecursive(root.right, currentPath, S);
		/* Remove current element for going up in the recursion call stack */
		
		currentPath.remove(currentPath.size()-1);
	    return pathCount;
	  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
  }
}