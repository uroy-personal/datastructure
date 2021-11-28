package practice.tree;

public class InOrderSuccessor {
	public TreeNode getInorderSuccessor(TreeNode node) {
		// if its a root node or it hs having a right subtree, get the left most node from the right subtree
		if(node.parent==null || node.right!=null) {
			return getLeftMostChild(node.right);
		}else{
			TreeNode tempParent = node.parent;
			TreeNode tempNode = node;
			
			while(tempParent!=null && tempParent.left!=tempNode) {
				tempNode = tempParent;
				tempParent = tempParent.parent;
			}
		}
		return null;
		
	}
	public TreeNode getLeftMostChild(TreeNode node) {
		if(node == null) {
			return null;
		}
		while(node.left!=null) {
			node = node.left;
		}
		return node;
	}
}
