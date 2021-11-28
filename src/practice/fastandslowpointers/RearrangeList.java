package practice.fastandslowpointers;



class RearrangeList {

  public static void reorder(FastAndSlowPointerListNode head) {
    if (head == null || head.next == null)
      return;

    // find the middle of the LinkedList
    FastAndSlowPointerListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // slow is now pointing to the middle node
    FastAndSlowPointerListNode headSecondHalf = reverse(slow); // reverse the second half
    FastAndSlowPointerListNode headFirstHalf = head;

    // rearrange to produce the LinkedList in the required order
    while (headFirstHalf != null && headSecondHalf != null) {
    	FastAndSlowPointerListNode temp = headFirstHalf.next;
      headFirstHalf.next = headSecondHalf;
      headFirstHalf = temp;

      temp = headSecondHalf.next;
      headSecondHalf.next = headFirstHalf;
      headSecondHalf = temp;
    }

    // set the next of the last node to 'null'
    if (headFirstHalf != null)
      headFirstHalf.next = null;
  }

  private static FastAndSlowPointerListNode reverse(FastAndSlowPointerListNode head) {
	  FastAndSlowPointerListNode prev = null;
    while (head != null) {
    	FastAndSlowPointerListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public static void main(String[] args) {
	  FastAndSlowPointerListNode head = new FastAndSlowPointerListNode(2);
    head.next = new FastAndSlowPointerListNode(4);
    head.next.next = new FastAndSlowPointerListNode(6);
    head.next.next.next = new FastAndSlowPointerListNode(8);
    head.next.next.next.next = new FastAndSlowPointerListNode(10);
    head.next.next.next.next.next = new FastAndSlowPointerListNode(12);
    RearrangeList.reorder(head);
    while (head != null) {
      System.out.print(head.value + " ");
      head = head.next;
    }
  }
}