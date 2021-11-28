package practice.graph.GraphAdjacencyList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

  ArrayList<AdjacencyListGraphNode> nodeList = new ArrayList<AdjacencyListGraphNode>();

  public Graph(ArrayList<AdjacencyListGraphNode> nodeList) {
    this.nodeList = nodeList;
  }

  public void addUndirectedEdge(int i, int j) {
	  AdjacencyListGraphNode first = nodeList.get(i);
	  AdjacencyListGraphNode second = nodeList.get(j);
    first.neighbors.add(second);
    second.neighbors.add(first);
  }



// For printing Graph to the console

  public String toString() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < nodeList.size(); i++) {
      s.append(nodeList.get(i).name + ": ");
      for (int j =0; j < nodeList.get(i).neighbors.size(); j++) {
        if (j == nodeList.get(i).neighbors.size()-1 ) {
          s.append((nodeList.get(i).neighbors.get(j).name) );
        } else {
          s.append((nodeList.get(i).neighbors.get(j).name) + " -> ");
        }
      }
      s.append("\n");
    }
    return s.toString();
  }


  // BFS internall
  void bfsVisit(AdjacencyListGraphNode node) {
    LinkedList<AdjacencyListGraphNode> queue = new LinkedList<AdjacencyListGraphNode>();
    queue.add(node);
    while (!queue.isEmpty()) {
    	AdjacencyListGraphNode currentNode = queue.remove(0);
      currentNode.isVisited = true;
      System.out.print(currentNode.name + " ");
      for (AdjacencyListGraphNode neighbor : currentNode.neighbors) {
        if (!neighbor.isVisited) {
          queue.add(neighbor);
          neighbor.isVisited=true;
        }
      }
    }
  }

  void bfs() {
    for (AdjacencyListGraphNode node : nodeList) {
      if (!node.isVisited) {
        bfsVisit(node);
      }
    }
  }

  void dfsVisit(AdjacencyListGraphNode node) {
    Stack<AdjacencyListGraphNode> stack = new Stack<>();
    stack.push(node);
    while (!stack.isEmpty()) {
    	AdjacencyListGraphNode currentNode = stack.pop();
      currentNode.isVisited = true;
      System.out.print(currentNode.name + " ");
      for (AdjacencyListGraphNode neighbor : currentNode.neighbors) {
        if (!neighbor.isVisited) {
          stack.push(neighbor);
          neighbor.isVisited=true;
        }
      }
    }
  }

  void dfs() {
    for (AdjacencyListGraphNode node : nodeList) {
      if(!node.isVisited) {
        dfsVisit(node);
      }
    }
  }

  // Topological Sort
 public void addDirectedEdge(int i, int j) {
	 AdjacencyListGraphNode first = nodeList.get(i);
	 AdjacencyListGraphNode second = nodeList.get(j);
   first.neighbors.add(second);
 }

 void topologicalVisit(AdjacencyListGraphNode node, Stack<AdjacencyListGraphNode> stack) {
   for (AdjacencyListGraphNode neighbor : node.neighbors) {
     if (!neighbor.isVisited) {
       topologicalVisit(neighbor, stack);
     }
   }
   node.isVisited = true;
   stack.push(node);
 }

 void topologicalSort() {
   Stack<AdjacencyListGraphNode> stack = new Stack<>();
   for (AdjacencyListGraphNode node : nodeList) {
     if (!node.isVisited) {
       topologicalVisit(node, stack);
     }
   }
   while(!stack.isEmpty()) {
     System.out.print(stack.pop().name + " ");
   }
 }
 
 public static void pathPrint(AdjacencyListGraphNode node) {
	   if (node.parent  != null) {
	     pathPrint(node.parent);
	   }
	   System.out.print(node.name + " ");
	 }

	 public void BFSForSSSPP(AdjacencyListGraphNode node) {
	   LinkedList<AdjacencyListGraphNode> queue = new LinkedList<>();
	   queue.add(node);
	   while(!queue.isEmpty()) {
		   AdjacencyListGraphNode currentNode = queue.remove(0);
	     currentNode.isVisited = true;
	     System.out.print("Printing path for node " + currentNode.name + ": ");
	     pathPrint(currentNode);
	     System.out.println();
	     for (AdjacencyListGraphNode neighbor : currentNode.neighbors) {
	       if (!neighbor.isVisited) {
	         queue.add(neighbor);
	         neighbor.isVisited = true;
	         neighbor.parent = currentNode;
	       }
	     }

	   }
	 }


}
