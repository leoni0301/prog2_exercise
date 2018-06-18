package graphs;

import complexnodes.Edge;
import complexnodes.Node;

import java.io.IOException;
import java.util.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GraphWithAdjacencyList implements Graph {

  private HashMap<String, Node> nodes;
  private ArrayList<Edge> edges;
  private Integer nodeCount;

  public GraphWithAdjacencyList(String filename) {

    try {
      List<String> lines = Files.readAllLines(Paths.get(filename));

      nodeCount = 0;
      nodes = new HashMap<>();
      edges = new ArrayList<>();

      Iterator<String> iter = lines.iterator();
      while (iter.hasNext()) {
        String line = iter.next();
        String[] parts = line.split(" ");
        if (lines.indexOf(line) > 0) {
          // Andere Zeilen
          edges.add(new Edge(nodes.get(parts[0]), nodes.get(parts[1]), parts[0] + " " + parts[1], 0));
        } else {
          // Erste Zeile
          for (Integer i = 0; i < parts.length; i++) {
            nodes.put(parts[i], new Node(parts[i], i));
            nodeCount++;
          }
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean containsEdge(String i, String j) throws InvalidNodeException {
    return edges.stream().anyMatch(e -> e.getFirstNode().getLabel().equals(i) && e.getSecondNode().getLabel().equals(j));
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

  public Integer getNodeCount() {
    return nodeCount;
  }
}
