package practice.treedfs;

public class TreeHeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.right.left = new TreeNode(5);
	    root.right.right = new TreeNode(6);
	    System.out.println("Tree height: " + TreeHeight.findHeight(root));
	}

	private static int findHeight(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return 0;
		}
		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);
		
		return Math.max(leftHeight, rightHeight)+1;
	}

}
