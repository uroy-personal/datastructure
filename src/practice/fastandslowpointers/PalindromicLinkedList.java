package practice.fastandslowpointers;




class PalindromicLinkedList {

  public static boolean isPalindrome(FastAndSlowPointerListNode head) {
    if (head == null || head.next == null)
      return true;

    // find middle of the LinkedList
    FastAndSlowPointerListNode slow = head;
    FastAndSlowPointerListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    FastAndSlowPointerListNode headSecondHalf = reverse(slow); // reverse the second half
    FastAndSlowPointerListNode copyHeadSecondHalf = headSecondHalf; // store the head of reversed part to revert back later

    // compare the first and the second half
    while (head != null && headSecondHalf != null) {
      if (head.value != headSecondHalf.value) {
        break; // not a palindrome
      }
      head = head.next;
      headSecondHalf = headSecondHalf.next;
    }

    reverse(copyHeadSecondHalf); // revert the reverse of the second half
    if (head == null || headSecondHalf == null) // if both halves match
      return true;
    return false;
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
    head.next.next.next = new FastAndSlowPointerListNode(4);
    head.next.next.next.next = new FastAndSlowPointerListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

    head.next.next.next.next.next = new FastAndSlowPointerListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
  }
}