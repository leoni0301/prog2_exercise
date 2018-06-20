package complexnodes;

public abstract class EdgeVariant<T1, T2> extends Number{
    private final T1 nodeA;
    private final T2 nodeB;
    private final String label;
    private final double weight;

    public EdgeVariant(T1 nodeA, T2 nodeB, String label, double weight) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.label = label;
        this.weight = weight;
    }
    
    public T1 getFirstNode() {
        return nodeA;
    }
    
    public T2 getSecondNode() {
        return nodeB;
    }    
    
    public String getLabel() {
        return label;
    }
    
    public double getWeight() {
        return weight;
    }
}
