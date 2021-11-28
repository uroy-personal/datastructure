package practice.amazonquestions;

//Java program to convert a given Binary Tree to Doubly Linked List

/* Structure for tree and Linked List */
class BTDLLNode {
	int data;
	BTDLLNode left, right;

	public BTDLLNode(int data)
	{
		this.data = data;
		left = right = null;
	}
}






public class BinaryTreeToDLL {

	// root --> Root of Binary Tree
	BTDLLNode root;

	// head --> Pointer to head BTDLLNode of created doubly linked list
	BTDLLNode head;

	// A simple recursive function to convert a given
	// Binary tree to Doubly Linked List
	void BToDLL(BTDLLNode root)
	{
		// Base cases
		if (root == null)
			return;

		// Recursively convert right subtree
		BToDLL(root.right);

		// insert root into DLL
		root.right = head;

		// Change left pointer of previous head
		if (head != null)
			head.left = root;

		// Change head of Doubly linked list
		head = root;

		// Recursively convert left subtree
		BToDLL(root.left);
	}

	// Utility function for printing double linked list.
	void printList(BTDLLNode head)
	{
		System.out.println("Extracted Double Linked List is : ");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
	}

	// Driver program to test the above functions
	public static void main(String[] args)
	{
		/* Constructing below tree
			5
			/ \
			3	 6
		/ \	 \
		1 4	 8
		/ \	 / \
		0 2	 7 9 */

		BinaryTreeToDLL tree = new BinaryTreeToDLL();
		tree.root = new BTDLLNode(5);
		tree.root.left = new BTDLLNode(3);
		tree.root.right = new BTDLLNode(6);
		tree.root.left.right = new BTDLLNode(4);
		tree.root.left.left = new BTDLLNode(1);
		tree.root.right.right = new BTDLLNode(8);
		tree.root.left.left.right = new BTDLLNode(2);
		tree.root.left.left.left = new BTDLLNode(0);
		tree.root.right.right.left = new BTDLLNode(7);
		tree.root.right.right.right = new BTDLLNode(9);

		tree.BToDLL(tree.root);
		tree.printList(tree.head);
	}

}
