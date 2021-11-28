package practice.fastandslowpointers;

class MiddleOfLinkedList {

	public static FastAndSlowPointerListNode findMiddle(FastAndSlowPointerListNode head) {
		FastAndSlowPointerListNode slow = head;
		FastAndSlowPointerListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static void main(String[] args) {
		FastAndSlowPointerListNode head = new FastAndSlowPointerListNode(1);
		head.next = new FastAndSlowPointerListNode(2);
		head.next.next = new FastAndSlowPointerListNode(3);
		head.next.next.next = new FastAndSlowPointerListNode(4);
		head.next.next.next.next = new FastAndSlowPointerListNode(5);
		System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

		head.next.next.next.next.next = new FastAndSlowPointerListNode(6);
		System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

		head.next.next.next.next.next.next = new FastAndSlowPointerListNode(7);
		System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
	}
}