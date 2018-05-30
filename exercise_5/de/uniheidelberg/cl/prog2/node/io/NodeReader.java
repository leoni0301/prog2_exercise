
package de.uniheidelberg.cl.prog2.node.io;

import de.uniheidelberg.cl.prog2.node.Node;

import java.io.*;

/**
 * Reads parse trees (de.uniheidelberg.cl.prog2.node.Node objects) from  file and returns an iterator over the Nodes
 *
 * @author ruppenhofer, building on:
 * @author ks spreyer@cl.uni-heidelberg.de
 */
public class NodeReader {

  private BufferedReader br;
  private boolean hasMore;
  private Node nextNode;

  // Konstruktor
  public NodeReader(FileReader in) {
    this.br = new BufferedReader(in);
    this.hasMore = true;
    computeNextNode();
  }

  // public method
  public Node next() {
    Node nt = this.nextNode;
    computeNextNode();
    return nt;
  }

  // public method
  public boolean hasNext() {
    return this.hasMore;
  }

  // public method
  public void close() {
    try {
      this.br.close();
    } catch (IOException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
  }


  /**
   * Die Methode soll bei jedem Aufruf eine einzelne Zeile aus br lesen. Falls diese Zeile
   * gleich null ist, sollen die Instanzvariablen hasMore und nextNode auf false bzw.
   * null gesetzt werden.
   * Andernfalls soll die parse-Methode der Klasse de.uniheidelberg.cl.prog2.node.Node aufgerufen
   * werden, um für die textuelle Syntaxbaum-Darstellung in der aktuellen Zeile ein
   * de.uniheidelberg.cl.prog2.node.Node-Objekt zu erhalten. Dieses Objekt soll dann in nextNode gespeichert werden.
   * Beachten Sie, dass die I/O-Operationen des BufferedReader’s von einem try/catch-
   * Block umgeben werden müssen. (4 Punkte)
   */


  private void computeNextNode() {
    try {
      String line = this.br.readLine();
      if (line == null) {
        this.hasMore = false;
        this.nextNode = null;
      } else {
        Node Nodeobj = Node.parse(new StringBuilder(line));
        this.nextNode = Nodeobj;
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.err.println(e.getMessage());
      System.exit(1);
    }
  }


  public static void main(String[] args) {

    try {
      FileReader in = new FileReader(args[0]);
      NodeReader nr = new NodeReader(in);
      while (nr.hasNext()) {
        System.out.println("PARSE " + nr.next());
      }
      nr.close();
    } catch (IOException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
  }

}
