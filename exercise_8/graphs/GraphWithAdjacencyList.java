package graphs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GraphWithAdjacencyList implements Graph {

  HashMap<String,ArrayList<String>> adjacencyList;

  // Laufzeit: O(n)
  public GraphWithAdjacencyList(String filename) {
    try {
      List<String> lines = Files.readAllLines(Paths.get(filename));

      adjacencyList = new HashMap<>();

      for (String line : lines) {
        String[] parts = line.split(" ");
        if (lines.indexOf(line) > 0) {
          // Andere Zeilen
          String leftNode = parts[0];
          String neighbourNode = parts[1];
          ArrayList<String> neighbors = adjacencyList.get(leftNode);
          neighbors.add(neighbourNode);
        } else {
          // Erste Zeile
          for (Integer i = 0; i < parts.length; i++) {
            String currentNode = parts[i];
            ArrayList<String> neighbors = new ArrayList<String>();
            adjacencyList.put(currentNode, neighbors);
          }
          }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Laufzeit: O(1)
  @Override
  public boolean containsEdge(String i, String j) throws InvalidNodeException {
    if (!adjacencyList.containsKey(i) && !adjacencyList.containsKey(j)) {
      throw new InvalidNodeException("i and j are not both contained in the graph.");
    }
    boolean leftNodeExists = adjacencyList.containsKey(i);
    if (leftNodeExists) {
      return adjacencyList.get(i).contains(j);
    } else {
      return false;
    }
  }

  // Laufzeit: O(1)
  @Override
  public Collection<String> getNeighbours(String i) throws InvalidNodeException {
    if (!adjacencyList.containsKey(i)) {
      throw new InvalidNodeException("i is not contained in the graph.");
    }
    return adjacencyList.get(i);
  }

  // Laufzeit: O(1)
  @Override
  public boolean addEdge(String i, String j) throws InvalidNodeException {
    if (!adjacencyList.containsKey(i) && !adjacencyList.containsKey(j)) {
      throw new InvalidNodeException("i and j are not both contained in the graph.");
    }
    boolean alreadyExisted = adjacencyList.get(i).contains(j);
    if (!alreadyExisted) {
      adjacencyList.get(i).add(j);
    }
    return alreadyExisted;
  }

  // Laufzeit: O(1)
  @Override
  public boolean addNode(String i) {
    boolean alreadyExisted = adjacencyList.containsKey(i);
    if (!alreadyExisted) {
      adjacencyList.put(i, new ArrayList<>());
    }
    return alreadyExisted;
  }
}
