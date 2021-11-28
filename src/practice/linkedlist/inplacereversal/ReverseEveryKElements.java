package practice.linkedlist.inplacereversal;

public class ReverseEveryKElements {
	

		  public static InPlaceReversalListNode reverse(InPlaceReversalListNode head, int k) {
			  if(k<=1 || head==null || head.next ==null) {
				  return head;
			  }
			  /* three pointers for sublist reversal */
			  
			  InPlaceReversalListNode currentNode = head;
			  InPlaceReversalListNode previousNode = null;
			  InPlaceReversalListNode nextNode = null;
			  /* two additional pointers for linking
			   * 
			   */
			  InPlaceReversalListNode lastNodeOfPreviousSublist = null;
			  InPlaceReversalListNode lastNodeOfcurrentSublist = null;
			  
			  while(true) {
				  lastNodeOfPreviousSublist = previousNode;
				  lastNodeOfcurrentSublist = currentNode;
				  for(int i=0;i<k && currentNode!=null ; i++ ) {
					  nextNode = currentNode.next;
					  currentNode.next = previousNode;
					  previousNode = currentNode;
					  currentNode = nextNode; 
					  
				  }
				  /*
				   *  connect previous node to lastNodeOfPreviousSublist;
				   */
				  if(lastNodeOfPreviousSublist==null) {
					  head = previousNode;
				  }else {
					  lastNodeOfPreviousSublist.next = previousNode; 
				  }
				  
				  /*
				   *  connect to the next node;
				   */
				  lastNodeOfcurrentSublist.next = currentNode;
				  
				  if(currentNode==null) {
					  break;
				  }
				  previousNode = lastNodeOfcurrentSublist;
			  }
			  return head;
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
		    head.next.next.next.next.next = new InPlaceReversalListNode(6);
		    head.next.next.next.next.next.next = new InPlaceReversalListNode(7);
		    head.next.next.next.next.next.next.next = new InPlaceReversalListNode(8);
		    
		    System.out.print("Nodes of the original  LinkedList are: ");
		    printLinkedList(head);
		    InPlaceReversalListNode result = ReverseEveryKElements.reverse(head, 3);
		    System.out.print("Nodes of the reversed LinkedList are: ");
		    printLinkedList(result);
			/*
			 * while (result != null) { System.out.print(result.value + " "); result =
			 * result.next; }
			 */
		  }
}
