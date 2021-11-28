package practice.amazonquestions;

class BSTNode
{
    int data;
    BSTNode left;
    BSTNode right;
    BSTNode(int key)
    {
        data = key;
        left = null;
        right = null;
    }
}
public class ValidateBST {
	BSTNode root; 
    
    //Function to check whether a Binary Tree is BST or not.
    boolean isBST(BSTNode root)  
    { 
        return isBSTUtil(root, Integer.MIN_VALUE,Integer.MAX_VALUE); 
    } 
  
    boolean isBSTUtil(BSTNode node, int min, int max) 
    { 
        //an empty tree is BST so we return true.
        if (node == null) 
            return true; 
  
        //returning false if this node violates the min/max constraint.
        if (node.data < min || node.data > max) 
            return false; 
  
        //otherwise checking the subtrees recursively.
        //tightening the min or max constraint.
        return (isBSTUtil(node.left, min, node.data-1) && 
                isBSTUtil(node.right, node.data+1, max)); 
    } 
}
