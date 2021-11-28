package practice.treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNodeLeftView {
	  int val;
	  TreeNodeLeftView left;
	  TreeNodeLeftView right;

	  TreeNodeLeftView(int x) {
	    val = x;
	  }
	};

public class LeftViewTree {
	public static List<TreeNodeLeftView> traverse(TreeNodeLeftView root) {
        List<TreeNodeLeftView> result = new ArrayList<>();
        Queue<TreeNodeLeftView> queue = new LinkedList<TreeNodeLeftView>();
        
        queue.add(root);
        while(!queue.isEmpty()) {
        	
        	int levelSize = queue.size();
        	
        	for(int i=0;i<levelSize;i++) {
        		
        		TreeNodeLeftView temp = queue.poll();
        		
        		if(temp.left!=null) {
        			queue.add(temp.left);
        		}
        		
        		if(temp.right!=null) {
        			queue.add(temp.right);
        		}
        		if(i==0) {
        			result.add(temp);
        		}
        	}
        	
        }
        
	    return result;
	} 
	public static void main(String[]args) {
		TreeNodeLeftView root = new TreeNodeLeftView(12);
	    root.left = new TreeNodeLeftView(7);
	    root.right = new TreeNodeLeftView(1);
	    root.left.left = new TreeNodeLeftView(9);
	    root.right.left = new TreeNodeLeftView(10);
	    root.right.right = new TreeNodeLeftView(5);
	    root.left.left.left = new TreeNodeLeftView(3);
	    List<TreeNodeLeftView> result = LeftViewTree.traverse(root);
	    for (TreeNodeLeftView node : result) {
	      System.out.print(node.val + " ");
	    }
	  }
}
