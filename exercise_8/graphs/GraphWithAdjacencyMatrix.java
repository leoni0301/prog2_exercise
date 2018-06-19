package graphs;

import java.io.IOException;
import java.util.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GraphWithAdjacencyMatrix implements Graph {

  private HashMap<String, Integer> nodes;
  private Integer nodeCount;
  private boolean[][] adjacencyMatrix;

  // Laufzeit: O(n)
  public GraphWithAdjacencyMatrix(String filename) {

    try {
      List<String> lines = Files.readAllLines(Paths.get(filename));

      nodeCount = 0;
      nodes = new HashMap<>();

      Iterator<String> iter = lines.iterator();
      while (iter.hasNext()) {
        String line = iter.next();
        String[] parts = line.split(" ");
        if (lines.indexOf(line) > 0) {
          // Andere Zeilen
          String leftNode = parts[0];
          String rightNode = parts[1];
          Integer leftNodeIndex = nodes.get(leftNode);
          Integer rightNodeIndex = nodes.get(rightNode);
          adjacencyMatrix[leftNodeIndex][rightNodeIndex] = true;
        } else {
          // Erste Zeile
          for (Integer i = 0; i < parts.length; i++) {
            nodes.put(parts[i], i);
            nodeCount++;
          }
          adjacencyMatrix = new boolean[nodeCount][nodeCount];
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Laufzeit: O(1)
  @Override
  public boolean containsEdge(String i, String j) throws InvalidNodeException {
    if (!nodes.containsKey(i) && !nodes.containsKey(j)) {
      throw new InvalidNodeException("i and j are not both contained in the graph.");
    }
    return adjacencyMatrix[nodes.get(i)][nodes.get(j)];
  }

  // Laufzeit: O(n)
  @Override
  public Collection<String> getNeighbours(String i) throws InvalidNodeException {
    if (!nodes.containsKey(i)) {
      throw new InvalidNodeException("i is not contained in the graph.");
    }
    Integer myIndex = nodes.get(i);
    ArrayList<String> neighbours = new ArrayList<>();
    for (String label : nodes.keySet()) {
      Integer otherIndex = nodes.get(label);
      if (otherIndex != myIndex) {
        if (adjacencyMatrix[myIndex][otherIndex]) {
          neighbours.add(label);
        }
      }
    }
    return neighbours;
  }

  // Laufzeit: O(1)
  @Override
  public boolean addEdge(String i, String j) throws InvalidNodeException {
    if (!nodes.containsKey(i) && !nodes.containsKey(j)) {
      throw new InvalidNodeException("i and j are not both contained in the graph.");
    }
    boolean alreadyExisted = adjacencyMatrix[nodes.get(i)][nodes.get(j)];
    if (!alreadyExisted) {
      adjacencyMatrix[nodes.get(i)][nodes.get(j)] = true;
    }
  return alreadyExisted;
}

  // Laufzeit: O(1)
  @Override
  public boolean addNode(String i) {
    boolean alreadyExisted = nodes.containsKey(i);
    if (!alreadyExisted) {
      nodes.put(i, nodeCount);
      nodeCount++;

      boolean[][] newAdjMatrix = new boolean[nodeCount][nodeCount];
      System.arraycopy(adjacencyMatrix, 0, newAdjMatrix, 0, adjacencyMatrix.length);
      adjacencyMatrix = newAdjMatrix;
    }
    return alreadyExisted;
  }

  public Integer getNodeCount() {
    return nodeCount;
  }
}
