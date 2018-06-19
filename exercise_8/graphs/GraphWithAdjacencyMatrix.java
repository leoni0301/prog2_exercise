package graphs;

import java.io.IOException;
import java.util.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GraphWithAdjacencyMatrix implements Graph {

  private HashMap<String, Integer> nodes;
  private Integer nodeCount;
  private boolean[][] adjacencyMatrix;

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

  @Override
  public boolean containsEdge(String i, String j) throws InvalidNodeException {
    return adjacencyMatrix[nodes.get(i)][nodes.get(j)];
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
