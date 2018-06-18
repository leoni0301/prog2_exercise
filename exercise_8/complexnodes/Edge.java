package complexnodes;

public class Edge {
    private final Node nodeA;
    private final Node nodeB;
    private final String label;
    private final double weight;
    
    public Edge(Node nodeA, Node nodeB, String label, double weight) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.label = label;
        this.weight = weight;
    }
    
    public Node getFirstNode() {
        return nodeA;
    }
    
    public Node getSecondNode() {
        return nodeB;
    }    
    
    public String getLabel() {
        return label;
    }
    
    public double getWeight() {
        return weight;
    }
}
