package practice.graph.GraphAdjacencyMatrix;
public class AdjacencyMatrixGraphNode {
  public String name;
  public int index;
  public boolean isVisited = false;
  public AdjacencyMatrixGraphNode parent;
  public AdjacencyMatrixGraphNode(String name, int index) {
    this.name = name;
    this.index = index;
  }
}
