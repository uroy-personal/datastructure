package practice.amazonquestions;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
public class ReverseLinkedListGroupOfk {
    public static Node reverse(Node node, int k)
    {
        Node curr = node, prev = null, next = null;
        int count = 0;
        
        while(curr != null && count < k)
        // reversing k elements :
        {
            next = curr.next;                 // marking next node
		    curr.next = prev;                 // reversing link
		    prev = curr;                      // updating prev
		    curr = next;                      // updating current
		    count++;
        }
        
        if (next != null)         // checking if there are nodes ahead
            node.next = reverse(next, k);     // reversing those recursively 
        
        return prev;
    }
}
