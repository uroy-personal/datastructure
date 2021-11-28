package practice.heapusingpriorityqueue;

//Java code to illustrate poll()
import java.util.*;

public class PriorityQueueDemo {
	public static void main(String args[])
	{
		// Creating an empty PriorityQueue
		PriorityQueue<String> queue = new PriorityQueue<String>();

		// Use add() method to add elements into the Queue
		queue.add("Welcome");
		queue.add("To");
		queue.add("Geeks");
		queue.add("For");
		queue.add("Geeks");
		queue.add("moons");


		// Displaying the PriorityQueue
		// System.out.println("Initial PriorityQueue: ");
		// System.out.println( queue);
		// Fetching and removing the element at the head of the queue
		while(!queue.isEmpty()) {
		System.out.println("The element at the head of the"
						+ " queue is: " + queue.poll());
		}

		// Displaying the Queue after the Operation
		// System.out.println("Final PriorityQueue:");
		// System.out.println( queue);
	}
}
