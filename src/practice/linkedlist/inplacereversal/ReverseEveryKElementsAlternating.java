package practice.linkedlist.inplacereversal;

public class ReverseEveryKElementsAlternating {

	public static void main(String[] args) {
		InPlaceReversalListNode head = new InPlaceReversalListNode(1);
	    head.next = new InPlaceReversalListNode(2);
	    head.next.next = new InPlaceReversalListNode(3);
	    head.next.next.next = new InPlaceReversalListNode(4);
	    head.next.next.next.next = new InPlaceReversalListNode(5);
	    head.next.next.next.next.next = new InPlaceReversalListNode(6);
	    head.next.next.next.next.next.next = new InPlaceReversalListNode(7);
	    head.next.next.next.next.next.next.next = new InPlaceReversalListNode(8);
	    
	    
	    System.out.print("Nodes of the original LinkedList are: " );
	    printList(head);
	    
	    InPlaceReversalListNode result = ReverseEveryKElementsAlternating.reverse(head, 2);
	    
	    System.out.print("Nodes of the reversed LinkedList are: " );
	    printList(result);
	    
	  }
	public static void printList(InPlaceReversalListNode node) {
		  while(node!=null) {
			  System.out.printf(" %s", node.value);
			  node=node.next;
		  }
		 System.out.println(""); 
	}
	private static InPlaceReversalListNode reverse(InPlaceReversalListNode head, int i) {
		/* Three pointers for in-place reversal */
		InPlaceReversalListNode currentNode=head;
		InPlaceReversalListNode previousNode=null;
		InPlaceReversalListNode nextNode=null;
		
		InPlaceReversalListNode previousSublistLastNode=null;
		InPlaceReversalListNode currentSublistLastNode=null;
		boolean reverse=true;
		
		
		while(true) {
			
			if(reverse) {
				previousSublistLastNode = previousNode;
				currentSublistLastNode = currentNode;
				for(int k=0;k<i && currentNode!=null ;k++) {
					nextNode = currentNode.next;
					currentNode.next = previousNode;
					previousNode = currentNode;
					currentNode = nextNode;
				}
				/* link with previous node */
				if(previousSublistLastNode==null) {
					head = previousNode;
				}else {
					previousSublistLastNode.next = previousNode;
				}
				
				/* link with the next node */
				currentSublistLastNode.next = currentNode;
				// break condition
				
				previousNode = currentSublistLastNode;
			}else {
				for(int l=0;l<i;l++) {
					previousSublistLastNode = currentNode;
					currentSublistLastNode = currentNode;
					previousNode = currentNode;
					currentNode = currentNode.next;
				}
				
			}
			if(currentNode==null) {
				break;
			}
			reverse=!reverse;
		}
		
		return head;
	}
}
