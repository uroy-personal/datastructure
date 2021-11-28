package practice.fastandslowpointers;



 public	class LinkedListCycle {

	  public static boolean hasCycle(FastAndSlowPointerListNode head) {
	    // TODO: Write your code here
		  FastAndSlowPointerListNode slow =null;
		  FastAndSlowPointerListNode fast =null;
		  if(head==null || head.next==null) {
			  return false;
		  }
		  
		  slow = fast = head;
		  while(fast!=null && fast.next!=null) {
			  slow = slow.next;
			  fast=fast.next.next;
			  if(slow==fast) {
				  return true;
			  }
		  }
	    
	    
	    return false;
	  }

	  public static void main(String[] args) {
		  FastAndSlowPointerListNode head = new FastAndSlowPointerListNode(1);
	    head.next = new FastAndSlowPointerListNode(2);
	    head.next.next = new FastAndSlowPointerListNode(3);
	    head.next.next.next = new FastAndSlowPointerListNode(4);
	    head.next.next.next.next = new FastAndSlowPointerListNode(5);
	    head.next.next.next.next.next = new FastAndSlowPointerListNode(6);
	    System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

	    head.next.next.next.next.next.next = head.next.next;
	    System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

	    head.next.next.next.next.next.next = head.next.next.next;
	    System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
	  }
	}
