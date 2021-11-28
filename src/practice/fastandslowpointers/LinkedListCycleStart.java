package practice.fastandslowpointers;

public class LinkedListCycleStart {

	  public static FastAndSlowPointerListNode findCycleStart(FastAndSlowPointerListNode head) {
		  int cycleLength =findCycleLength(head);
		  
		  FastAndSlowPointerListNode first = head;
		  
		  FastAndSlowPointerListNode second = head;
		  
		  for(int i=0;i<cycleLength;i++) {
			  second = second.next;
		  }
		  
		  while(first!=second) {
			  first = first.next;
			  second = second.next;
		  }
		  
		  return first;
	  }
	  
	  public static int findCycleLength(FastAndSlowPointerListNode head) {
			if(head==null || head.next==null) {
				return 0;
			}
			FastAndSlowPointerListNode slow = head;
			FastAndSlowPointerListNode fast = head;
			
			while(fast!=null && fast.next!=null) {
				slow = slow.next;
				fast = fast.next.next;
				if(slow==fast) {
					break;
				}
			}
			
			return calculateCycleLength(slow);
		}
	    public static int calculateCycleLength(FastAndSlowPointerListNode node) {
	    	int cycleLenght = 0;
	    	if(node==null) {
	    		return cycleLenght;
	    	}else {
	    		cycleLenght++;
	    	}
	    	FastAndSlowPointerListNode temp = node;
	    	while(node.next!=temp) {
	    		cycleLenght++;
	    		node=node.next;
	    	}
	    	return cycleLenght;
	    }
	    
	  public static void main(String[] args) {
		FastAndSlowPointerListNode head = new FastAndSlowPointerListNode(1);
	    head.next = new FastAndSlowPointerListNode(2);
	    head.next.next = new FastAndSlowPointerListNode(3);
	    head.next.next.next = new FastAndSlowPointerListNode(4);
	    head.next.next.next.next = new FastAndSlowPointerListNode(5);
	    head.next.next.next.next.next = new FastAndSlowPointerListNode(6);

	    head.next.next.next.next.next.next = head.next.next;
	    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

	    head.next.next.next.next.next.next = head.next.next.next;
	    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

	    head.next.next.next.next.next.next = head;
	    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
	  }
	}