package practice.linkedlist.inplacereversal;

class RotateList {

  public static InPlaceReversalListNode rotate(InPlaceReversalListNode head, int rotations) {
    if (head == null || head.next == null || rotations <= 0)
      return head;

    // find the length and the last node of the list
    InPlaceReversalListNode lastNode = head;
    int listLength = 1;
    while (lastNode.next != null) {
      lastNode = lastNode.next;
      listLength++;
    }

    lastNode.next = head; // connect the last node with the head to make it a circular list
    rotations %= listLength; // no need to do rotations more than the length of the list
    int skipLength = listLength - rotations;
    InPlaceReversalListNode lastNodeOfRotatedList = head;
    for (int i = 0; i < skipLength - 1; i++)
      lastNodeOfRotatedList = lastNodeOfRotatedList.next;

    // 'lastNodeOfRotatedList.next' is pointing to the sub-list of 'k' ending nodes
    head = lastNodeOfRotatedList.next;
    lastNodeOfRotatedList.next = null;
    return head;
  }

  public static void main(String[] args) {
	  InPlaceReversalListNode head = new InPlaceReversalListNode(1);
    head.next = new InPlaceReversalListNode(2);
    head.next.next = new InPlaceReversalListNode(3);
    head.next.next.next = new InPlaceReversalListNode(4);
    head.next.next.next.next = new InPlaceReversalListNode(5);
    head.next.next.next.next.next = new InPlaceReversalListNode(6);

    InPlaceReversalListNode result = RotateList.rotate(head, 3);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
    System.out.println("");
    System.out.println(24%7);
  }
}
