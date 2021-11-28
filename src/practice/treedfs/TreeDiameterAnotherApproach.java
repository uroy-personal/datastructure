package practice.treedfs;

public class TreeDiameterAnotherApproach {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.right.left = new TreeNode(5);
	    root.right.right = new TreeNode(6);
	    
	    System.out.println("Tree Diameter: " + TreeDiameterAnotherApproach.findDiameter(root));
	    
	    root.left.left = null;
	    root.right.left.left = new TreeNode(7);
	    root.right.left.right = new TreeNode(8);
	    root.right.right.left = new TreeNode(9);
	    root.right.left.right.left = new TreeNode(10);
	    root.right.right.left.left = new TreeNode(11);
	    System.out.println("Tree Diameter: " + TreeDiameterAnotherApproach.findDiameter(root));

	}

	private static int findDiameter(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return 0;
		}
		int lheight = getHeight(root.left);
		int rheight = getHeight(root.right);
		
		int ldiameter = findDiameter(root.left);
		int rdiameter = findDiameter(root.right);
		
		return Math.max(lheight + rheight + 1,
                Math.max(ldiameter, rdiameter));
	}
	
	private static int getHeight(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return 0;
		}
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		
		return Math.max(leftHeight, rightHeight)+1;
	}

}
