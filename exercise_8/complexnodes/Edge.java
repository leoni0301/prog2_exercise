package complexnodes;

public class Edge<T> {
    private final T nodeA;
    private final T nodeB;
    private final String label;
    private final double weight;
    
    public Edge(T nodeA, T nodeB, String label, double weight) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.label = label;
        this.weight = weight;
    }
    
    public T getFirstNode() {
        return nodeA;
    }
    
    public T getSecondNode() {
        return nodeB;
    }    
    
    public String getLabel() {
        return label;
    }
    
    public double getWeight() {
        return weight;
    }
}
