package graphs;

import java.util.Collection;

public class GraphWithAdjacencyList implements Graph {


  public GraphWithAdjacencyList(String filename) {
    
  }

  @Override
  public boolean containsEdge(String i, String j) throws InvalidNodeException {
    return false;
  }

  @Override
  public Collection<String> getNeighbours(String i) throws InvalidNodeException {
    return null;
  }

  @Override
  public boolean addEdge(String i, String j) throws InvalidNodeException {
    return false;
  }

  @Override
  public boolean addNode(String i) {
    return false;
  }
}
