package practice.graph.kruskal;

public class UndirectedEdge {
	public WeightedNode first = null;
    public WeightedNode second = null;
    public int weight;
    public UndirectedEdge(WeightedNode first, WeightedNode second, int weight) {
    	this.first = first;
    	this.second = second;
    	this.weight = weight;
    }
}
