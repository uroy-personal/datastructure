package practice.linkedlist.inplacereversal;

class ReverseSubList {

  public static InPlaceReversalListNode reverse(InPlaceReversalListNode head, int p, int q) {
	    InPlaceReversalListNode traversalNode = head;
		InPlaceReversalListNode previousNode = null;
		InPlaceReversalListNode nextNode = null;
		InPlaceReversalListNode windowStart = null;
		InPlaceReversalListNode windowEnd = null;
		
		int index =1;
		while(traversalNode!=null) {
			if(index==p-1) {
				windowStart =traversalNode;
			}
			if(index==q+1) {
				windowEnd =traversalNode;
			}
			traversalNode =traversalNode.next;
			index++;
		}
        
		
		System.out.println("==== window start === "+windowStart);
		System.out.println("==== window End === "+windowEnd);
		
		InPlaceReversalListNode reverseNode = windowStart.next;
		previousNode = windowEnd;
		int reverseIndex =1;
		while(reverseIndex<=q-p+1) {
			nextNode = reverseNode.next;
			reverseNode.next=previousNode;
			previousNode = reverseNode;
			reverseNode = nextNode;
			reverseIndex++;
		}
		windowStart.next = previousNode;
		return head;
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
		System.out.println();
		return previousNode;
	}
  public static void printLinkedList(InPlaceReversalListNode node) {
	  
	  while(node!=null) {
		  System.out.printf(" %s", node.value);
		  node=node.next;
	  }
	 System.out.println(""); 
  }
  public static void main(String[] args) {
	  InPlaceReversalListNode head = new InPlaceReversalListNode(1);
    head.next = new InPlaceReversalListNode(2);
    head.next.next = new InPlaceReversalListNode(3);
    head.next.next.next = new InPlaceReversalListNode(4);
    head.next.next.next.next = new InPlaceReversalListNode(5);
    printLinkedList(head);
    InPlaceReversalListNode result = ReverseSubList.reverse(head, 2, 4);
    System.out.println("Nodes of the reversed LinkedList are: ");
    printLinkedList(head);
  }
}
