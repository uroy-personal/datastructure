package practice.amazonquestions;
import java.util.*;
class EmbededNode
{
    int data;
    EmbededNode left;
    EmbededNode right;
    EmbededNode(int key)
    {
        data = key;
        left = null;
        right = null;
    }
}
class MyPair
{
	EmbededNode node;
    int hd;
    MyPair(EmbededNode n, int h)
    {
        node = n;
        hd = h;
    }
}

public class BinaryTreeVerticalOrderTraversal {



  //Function to find the vertical order traversal of Binary Tree.
	    static ArrayList <Integer> verticalOrder(EmbededNode root)
	    {
	        ArrayList <Integer> res = new ArrayList <Integer>(0);
	        
	        //creating empty queue for level order traversal.
	        Queue<MyPair>q=new LinkedList<MyPair>();
	        
	        //creating a map to store nodes at a particular horizontal distance.
	        Map<Integer,ArrayList<Integer>>mp=new TreeMap<>();
	        
	        q.add(new MyPair(root, 0));
	        
	        while(!q.isEmpty())
	        {
	            MyPair temp = q.poll();
	            EmbededNode temp_root = temp.node;
	            int hd = temp.hd;
	            if (mp.containsKey(hd))
	            {
	                ArrayList<Integer>al=mp.get(hd);
	                al.add(temp_root.data);
	                mp.put(hd,al);
	            }
	            else
	            {
	                ArrayList<Integer>al=new ArrayList<>();
	                al.add(temp_root.data);
	                mp.put(hd,al);
	            }
	            
	            //if left child of temp_root exists, pushing it in
	            //the queue with the horizontal distance.
	            if(temp_root.left!=null)
	                q.add(new MyPair(temp_root.left, hd-1));
	            
	            //if right child of temp_root exists, pushing it in
	            //the queue with the horizontal distance.
	            if(temp_root.right!=null)
	                q.add(new MyPair(temp_root.right, hd+1));
	            
	        }
	        
	        //traversing the map and storing the nodes in list 
	        //at every horizontal distance.
	        for(Map.Entry<Integer,ArrayList<Integer>>m:mp.entrySet())
	        {
	            ArrayList<Integer>al=m.getValue();
	            for(int i=0;i<al.size();i++)
	              res.add(al.get(i));
	        }
	        //returning the output list.
	        return res;
	    }
	}
	

