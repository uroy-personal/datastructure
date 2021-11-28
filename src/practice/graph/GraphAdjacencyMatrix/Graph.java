package practice.graph.GraphAdjacencyMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
  ArrayList<AdjacencyMatrixGraphNode> nodeList = new ArrayList<AdjacencyMatrixGraphNode>();
  int[][] adjacencyMatrix;

  public Graph(ArrayList<AdjacencyMatrixGraphNode> nodeList) {
    this.nodeList = nodeList;
    adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
  }

  public void addUndirectedEdge(int i, int j) {
    adjacencyMatrix[i][j] = 1;
    adjacencyMatrix[j][i] = 1;
  }

  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("   ");
    for (int i = 0; i < nodeList.size(); i++) {
      s.append(nodeList.get(i).name + " ");
    }
    s.append("\n");
    for (int i = 0; i < nodeList.size(); i++) {
      s.append(nodeList.get(i).name + ": ");
      for (int j : adjacencyMatrix[i]) {
        s.append((j) + " ");
      }
      s.append("\n");
    }
    return s.toString();
  }

  // get Neighbors
  public ArrayList<AdjacencyMatrixGraphNode> getNeighbors(AdjacencyMatrixGraphNode node) {
    ArrayList<AdjacencyMatrixGraphNode> neighbors = new ArrayList<AdjacencyMatrixGraphNode>();
    int nodeIndex = node.index;
    for (int i=0; i<adjacencyMatrix.length; i++) {
      if(adjacencyMatrix[nodeIndex][i]==1) {
        neighbors.add(nodeList.get(i));
      }
    }
    return neighbors;

  }

  // BSF internall
  void bfsVisit(AdjacencyMatrixGraphNode node) {
    LinkedList<AdjacencyMatrixGraphNode> queue = new LinkedList<AdjacencyMatrixGraphNode>();
    queue.add(node);
    while(!queue.isEmpty()) {
    	AdjacencyMatrixGraphNode currentNode = queue.remove(0);
      currentNode.isVisited = true;
      System.out.print(currentNode.name + " ");
      ArrayList<AdjacencyMatrixGraphNode> neighbors = getNeighbors(currentNode);
      for (AdjacencyMatrixGraphNode neighbor: neighbors) {
        if (!neighbor.isVisited) {
          queue.add(neighbor);
          neighbor.isVisited = true;
        }
      }
    }
  }

  public void bfs() {
    for (AdjacencyMatrixGraphNode node : nodeList) {
      if(!node.isVisited) {
        bfsVisit(node);
      }
    }
  }

  void dfsVisit(AdjacencyMatrixGraphNode node) {
    Stack<AdjacencyMatrixGraphNode> stack = new Stack<>();
    stack.push(node);
    while(!stack.isEmpty()) {
    	AdjacencyMatrixGraphNode currentNode = stack.pop();
      currentNode.isVisited = true;
      System.out.print(currentNode.name + " ");
      ArrayList<AdjacencyMatrixGraphNode> neighbors = getNeighbors(currentNode);
      for (AdjacencyMatrixGraphNode neighbor : neighbors) {
        if (!neighbor.isVisited) {
          stack.push(neighbor);
          neighbor.isVisited = true;
        }
      }

    }
  }

  void dfs() {
    for (AdjacencyMatrixGraphNode node : nodeList) {
      if(!node.isVisited) {
        dfsVisit(node);
      }
    }
  }
  
  //  Topological Sort
  public void addDirectedEdge(int i, int j) {
    adjacencyMatrix[i][j] = 1;
  }

  void topologicalVisit(AdjacencyMatrixGraphNode node, Stack<AdjacencyMatrixGraphNode> stack) {
    ArrayList<AdjacencyMatrixGraphNode> neighbors = getNeighbors(node);
    for (AdjacencyMatrixGraphNode neighbor : neighbors) {
      if (!neighbor.isVisited) {
        topologicalVisit(neighbor, stack);
      }
    }
    node.isVisited = true;
    stack.push(node);
  }

  void topologicalSort() {
    Stack<AdjacencyMatrixGraphNode> stack = new Stack<>();
    for (AdjacencyMatrixGraphNode node : nodeList) {
      if (!node.isVisited) {
        topologicalVisit(node, stack);
      }
    }

    while (!stack.isEmpty()) {
      System.out.print(stack.pop().name + " ");
    }
  }
  //Print path of each of the vertex from source
 public static void pathPrint(AdjacencyMatrixGraphNode node) {
   if(node.parent!=null) {
    pathPrint(node.parent);
  }
   System.out.print(node.name+" ");
 }

 public void BFSForSSSPP(AdjacencyMatrixGraphNode node) {
   LinkedList<AdjacencyMatrixGraphNode> queue = new LinkedList<>();
   queue.add(node);
   while(!queue.isEmpty()) {
	   AdjacencyMatrixGraphNode currentNode = queue.remove(0);
     currentNode.isVisited = true;
     System.out.print("Printing path for node "+currentNode.name+": ");
     pathPrint(currentNode);
     System.out.println();
     ArrayList<AdjacencyMatrixGraphNode> neighbors = getNeighbors(currentNode);
     for (AdjacencyMatrixGraphNode neighbor : neighbors) {
       if (!neighbor.isVisited) {
         queue.add(neighbor);
         neighbor.isVisited = true;
         neighbor.parent = currentNode;
       }
     }

   }
 }

}
