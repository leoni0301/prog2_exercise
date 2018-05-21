public class NichtTerminalKnoten extends Knoten {
  private Knoten[] children;

  NichtTerminalKnoten(String type, Knoten[] children) {
    super(type);

    this.children = children;
  }
}
