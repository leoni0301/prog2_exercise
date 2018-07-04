package solutions.graphs;

import java.util.Collection;


public interface Graph {
   /**
    * Checks whether an edge between i and j exists in the graph;
    * if i and j are nodes of the graph, the function should return
    * true if an edge between i and j exists in the graph,
    * false otherwise.
    *
    * @param i first node to check
    * @param j second node to check
    * @return true if an edge between i and j exists in the graph, or false otherwise
    * @throws InvalidNodeException if i and j are not both contained in the graph
    */
  public boolean containsEdge(String i, String j) throws InvalidNodeException;

  /**
   * Returns all nodes j for which there exists an edge from i to j.
   *
   * @param i node from which the neighbours are wanted
   * @return all nodes j for which there exists an edge from i to j
   * @throws InvalidNodeException if i is not contained in the graph
   */
  public Collection<String> getNeighbours(String i) throws InvalidNodeException;

  /**
   * Adds an edge between i and j to the graph;
   * if i and j are nodes of the graph, the function returns
   * true if an edge between i and j was not present in the graph and
   * was added, false if an edge between i and j already existed in the graph.
   *
   * @param i source node from which the edge is built
   * @param j target node to which the edge is built
   * @return true if an edge between i and j was not present in the graph and was added,
   * or false if an edge between i and j already existed in the graph
   * @throws InvalidNodeException if i and j are not contained in the graph
   *
   */
  public boolean addEdge(String i, String j) throws InvalidNodeException;

  /**
   * Adds a node i to the graph;
   * Returns true if a node i was not present in the graph and was added,
   * or false if it already existed in the graph.
   *
   * @param i node that is added
   * @return true if a node i was not present in the graph and was added,
   * or false if it already existed in the graph.
   */

  public boolean addNode(String i);
}

