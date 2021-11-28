package practice.linkedlist.inplacereversal;


public class InPlaceReversalListNode {
	  int value = 0;
	  InPlaceReversalListNode next;

	  public InPlaceReversalListNode(int value) {
	    this.value = value;
	  }

	@Override
	public String toString() {
		return "InPlaceReversalListNode [value=" + value + " , next ="+(next!=null? next.value:"")+" ]";
	}
	  
	  
	}