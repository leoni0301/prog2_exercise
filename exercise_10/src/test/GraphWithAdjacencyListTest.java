package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import solutions.graphs.GraphWithAdjacencyList;
import solutions.graphs.InvalidNodeException;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class GraphWithAdjacencyListTest {

    @Test
    public void constructorThrowsNoSuchFileException() {

      try {
        // sut = subject under test
        GraphWithAdjacencyList sut = new GraphWithAdjacencyList("nonExistingFile");
        Assertions.assertTrue(false);
      } catch (NoSuchFileException e) {
        Assertions.assertTrue(true);
      }
      catch (IOException e){
        Assertions.assertTrue(false);
      }
    }

  @Test
  public void getNeighboursThrowsInvalidNodeException() {
    try {
      GraphWithAdjacencyList sut = new GraphWithAdjacencyList("example_graph.txt");
      sut.getNeighbours("nonExistingNode");
      Assertions.assertTrue(false);
    } catch (IOException e) {
      Assertions.assertTrue(false);
    } catch (InvalidNodeException e) {
      Assertions.assertTrue(true);
    }
  }

  @Test
  public void containsEdgeWithSourceAndTargetInvalidThrowsInvalidNodeException() {

    try {
      GraphWithAdjacencyList sut = new GraphWithAdjacencyList("example_graph.txt");
      sut.containsEdge("nonExistingNode", "nonExistingNode");
      Assertions.assertTrue(false);
    } catch (IOException e) {
      Assertions.assertTrue(false);
    } catch (InvalidNodeException e) {
      Assertions.assertTrue(true);
    }
  }

  @Test
  public void containsEdgeWithSourceInvalidThrowsInvalidNodeException() {

    try {
      GraphWithAdjacencyList sut = new GraphWithAdjacencyList("example_graph.txt");
      sut.containsEdge("nonExistingNode", "Berg");
      Assertions.assertTrue(false);
    } catch (IOException e) {
      Assertions.assertTrue(false);
    } catch (InvalidNodeException e) {
      Assertions.assertTrue(true);
    }
  }

  @Test
  public void containsEdgeReturnsFalseOnNonEdge() {

    try {
      GraphWithAdjacencyList sut = new GraphWithAdjacencyList("example_graph.txt");
      Assertions.assertFalse(sut.containsEdge("Alpen", "Himalaya"));
    } catch (InvalidNodeException e) {
      Assertions.assertTrue(false);
    } catch (IOException e) {
      Assertions.assertTrue(false);
    }
  }
}
