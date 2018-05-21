public class NichtTerminalKnoten extends Knoten {
  private Knoten[] children;

  NichtTerminalKnoten(String type, Knoten[] children) {
    super(type);
    this.children = children;
  }

  public Knoten[] getChildren() {
    return this.children;
  }

  @Override
  public String toString() {
    String childrenString = "";
    for (Knoten k : children) {
      childrenString += k;
      // wenn das aktuelle Kind nicht das letzte Kind ist, dann füge ein Leerzeichen hinzu
      if (k != children[children.length - 1]) {
        childrenString += " ";
      }
    }

    return getType() + ":(" + childrenString + ")";
  }
}

// 5. Kindknoten können sowohl Instanzen von TerminalKnoten, als auch von NichtTerminalKnoten sein,
// deshalb muss der Typ des Kindknoten-Arrays die gemeinsame Superklasse Knoten sein.