package practice.amazonquestions;
import java.util.*;

class EmbededNode2
{
    int data;
    EmbededNode2 left;
    EmbededNode2 right;
    
}
public class LevelOrderTraversal {
	
	
	    //Function to return the level order traversal of a tree.
		static ArrayList <Integer> levelOrder(EmbededNode2 node)
	    {
			 ArrayList <Integer> res = new ArrayList <Integer> (0);
			 
			 //if node is null, we return the list.
			 if(node == null)
			    return res;
			    
			//creating an empty queue for level order traversal.
			Queue<EmbededNode2> q = new LinkedList<>();
			
			q.add(node);
			while(q.isEmpty() == false)
			{
			    //storing front element of queue in list and removing it from queue.
			    node = q.peek();
			    res.add (node.data);
			    q.poll();
			    
			    //storing the left child of the parent node in queue.
			    if(node.left != null)
			      q.add(node.left);
			      
			    //storing the right child of the parent node in queue.
			    if(node.right != null)
			      q.add(node.right);
			    
			}
			//returning the list.
			return res;
		}

	}
	

