package practice.linkedlist.inplacereversal;

public class ReverseLinkedList {

	public static void main(String[] args) {
		InPlaceReversalListNode head = new InPlaceReversalListNode(2);
	    head.next = new InPlaceReversalListNode(4);
	    head.next.next = new InPlaceReversalListNode(6);
	    head.next.next.next = new InPlaceReversalListNode(8);
	    head.next.next.next.next = new InPlaceReversalListNode(10);

	    InPlaceReversalListNode result = ReverseLinkedList.reverse(head);
	    System.out.print("Nodes of the reversed LinkedList are: ");
	    while (result != null) {
	      System.out.print(result.value + " ");
	      result = result.next;
	    }
	  }

	public static InPlaceReversalListNode reverse(InPlaceReversalListNode head) {
		// TODO Auto-generated method stub
		InPlaceReversalListNode currentNode = head;
		InPlaceReversalListNode previousNode = null;
		InPlaceReversalListNode nextNode = null;
		
		while(currentNode!=null) {
			nextNode = currentNode.next;
			currentNode.next=previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		
		return previousNode;
	}
}
