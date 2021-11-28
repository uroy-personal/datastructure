package practice.walmartlabs;
import java.util.*;

class TopViewNodeWrapper{
	TopViewNode topViewNode;
	int level;
	public TopViewNodeWrapper(TopViewNode topViewNode, int level) {
		this.topViewNode = topViewNode;
		this.level =level;
	}
}
public class TreeTopView {
	
	public static void bfs(TopViewNode root) {
		Queue<TopViewNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			
			int level = queue.size();
			for(int i=0;i<level;i++) {
			TopViewNode node = queue.poll();
			
			
			
			if(node.left!=null)queue.add(node.left);
			System.out.printf("%s ",node.data);
			if(node.right!=null)queue.add(node.right);
			}
			
			
		}
	}
	/*
	 * Root-Left-Right
	 * 
	 */
	public static void dfsPreOrder(TopViewNode node) {
		if(node==null) {
			return;
		}
		System.out.printf("%s ",node.data);
		dfsPreOrder(node.left);
		dfsPreOrder(node.right);
		
	}

	public static void dfsInOrder(TopViewNode node, int depth) {
		if(node==null) {
			return;
		}
		dfsInOrder(node.left, depth );
		System.out.printf("%s ",node.data);
		//if(depth==0) {
		dfsInOrder(node.right, ++depth);
		//}
		
		
	}
	
	public static List<Integer> onlyLeftTraversal(TopViewNode node){
		
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> returnList = new ArrayList<Integer>();
		
		while(node!=null) {
			stack.push(node.data);
			node = node.left;
		}
		while(!stack.isEmpty()) {
			returnList.add(stack.pop());
		}
		return returnList;
	}
	
	public static List<Integer> onlyRightTraversal(TopViewNode node){
		// Stack<Integer> stack = new Stack<Integer>();
		List<Integer> returnList = new ArrayList<Integer>();
		
		while(node!=null) {
			returnList.add(node.data);
			node = node.right;
		}
		
		return returnList;
	}
	
	
	public static void dfsPostOrder(TopViewNode node) {
		if(node==null) {
			return;
		}
		dfsPostOrder(node.left);
		dfsPostOrder(node.right);
		System.out.printf("%s ",node.data);
	}
    
	public static void viewTreeTopView(TopViewNode node) {
		Queue<TopViewNodeWrapper> topViewNodeWrapperQueue =  new LinkedList<TopViewNodeWrapper>();
		TopViewNodeWrapper topViewNodeWrapperNode = new TopViewNodeWrapper(node,1);
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		topViewNodeWrapperQueue.add(topViewNodeWrapperNode);
		
		while(!topViewNodeWrapperQueue.isEmpty()) {
			TopViewNodeWrapper retrievedNode = topViewNodeWrapperQueue.poll();
			
			if(!map.containsKey(retrievedNode.level)) {
				map.put(retrievedNode.level, retrievedNode.topViewNode.data);
			}
			
			if(retrievedNode.topViewNode.left!=null) {
				topViewNodeWrapperQueue.add(new TopViewNodeWrapper(retrievedNode.topViewNode.left,retrievedNode.level-1 ));
			}
			
			if(retrievedNode.topViewNode.right!=null) {
				topViewNodeWrapperQueue.add(new TopViewNodeWrapper(retrievedNode.topViewNode.right,retrievedNode.level+1 ));
			}
		}
		System.out.println(map.keySet());
		for(Map.Entry<Integer, Integer> mapEntry: map.entrySet() ) {
			System.out.printf(" %s ",mapEntry.getValue() );
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TopViewNode root = new TopViewNode(10);
		
		TopViewNode node20 = new TopViewNode(20);
		TopViewNode node30 = new TopViewNode(30);
		TopViewNode node40 = new TopViewNode(40);
		TopViewNode node60 = new TopViewNode(60);
		TopViewNode node90 = new TopViewNode(90);
		TopViewNode node100 = new TopViewNode(100);
		
		
		root.left = node20;
		root.right = node30;
		node20.left = node40;
		node20.right = node60;
		node30.left = node90;
		node30.right = node100;
		//System.out.println("BFS");
		System.out.println("");
	    // bfs(root);
	    List<Integer> leftTraversal = new ArrayList<Integer>();
	    List<Integer> rightTraversal = new ArrayList<Integer>();
	    
		/*
		 * onlyLeftTraversal(root); System.out.println(onlyLeftTraversal(root));
		 * onlyRightTraversal(root); System.out.println(onlyRightTraversal(root));
		 */
	    
	    
		//System.out.println("");
		//System.out.println("DFS - Preorder");
		// dfsPreOrder(root);
		//System.out.println("");
		//System.out.println("DFS - Inorder\n");
		//dfsInOrder(root,0);
		//System.out.println("");
		//System.out.println("DFS - Postorder\n");
		//dfsPostOrder(root);
	    
	    viewTreeTopView(root);
	}

}
