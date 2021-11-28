package practice.treebfs;
import java.util.*;
class TreeNodeZigZag {
	  int val;
	  TreeNodeZigZag left;
	  TreeNodeZigZag right;

	  TreeNodeZigZag(int x) {
	    val = x;
	  }
	};

public class ZigZagTraversal {
	
	public static List<List<Integer>> traverse(TreeNodeZigZag root) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNodeZigZag> nodeQueue = new LinkedList<TreeNodeZigZag>();
		boolean left2Right=true;
		nodeQueue.add(root);
		
		while(!nodeQueue.isEmpty()) {
			int levelSize =  nodeQueue.size();
			List<Integer> currentlevel = new ArrayList<Integer>();
			for(int i=0;i<levelSize;i++) {
				TreeNodeZigZag temp = nodeQueue.poll();
				if(left2Right) {
					currentlevel.add(temp.val);
				}else {
					currentlevel.add(0,temp.val);
				}
				if(temp.left!=null) {
					nodeQueue.add(temp.left);
				}
				if(temp.right!=null) {
					nodeQueue.add(temp.right);
				}
				
			}
			left2Right=!left2Right;
			result.add(currentlevel);
		}
		
		return result;
	}
	public static void main(String[]args) {
		TreeNodeZigZag root = new TreeNodeZigZag(12);
	    root.left = new TreeNodeZigZag(7);
	    root.right = new TreeNodeZigZag(1);
	    root.left.left = new TreeNodeZigZag(9);
	    root.right.left = new TreeNodeZigZag(10);
	    root.right.right = new TreeNodeZigZag(5);
	    root.right.left.left = new TreeNodeZigZag(20);
	    root.right.left.right = new TreeNodeZigZag(17);
	    List<List<Integer>> result = ZigZagTraversal.traverse(root);
	    System.out.println("Zigzag traversal: " + result);
	}
}
