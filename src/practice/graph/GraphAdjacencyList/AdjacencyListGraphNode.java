package practice.graph.GraphAdjacencyList;
import java.util.ArrayList;

public class AdjacencyListGraphNode {
  public String name;
  public int index;
  public boolean isVisited = false;
  public AdjacencyListGraphNode parent;
  public ArrayList<AdjacencyListGraphNode> neighbors = new ArrayList<AdjacencyListGraphNode>();

  public AdjacencyListGraphNode(String name, int index) {
    this.name = name;
    this.index = index;
  }
}
