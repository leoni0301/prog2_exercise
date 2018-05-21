public class KnotenTest {

  private static void validateType(Knoten knoten){
    if (knoten.getType() == "") {
      System.exit(0);
    }
  }

  private static void testKnotenType() {
    Knoten valid = new Knoten("bAse");
    validateType(valid);
    System.out.println("Der Typ ist gültig.");

    Knoten invalid = new Knoten("invalidType");
    validateType(invalid);
    System.out.println("Wenn dieser Text nicht ausgegeben wird, wurde das Programm beendet.");
  }

  private static void testTerminalKnoten() {
    TerminalKnoten tKnoten = new TerminalKnoten("root", "math", "N");
    System.out.println(tKnoten.toString());
  }

  private static void testNichtTerminalToString() {

    //Ebene 0   base1
    //           /   \
    //Ebene 1  math  base2
    //               /   \
    //Ebene 2     teach   er


    //Ebene 2
    TerminalKnoten teach = new TerminalKnoten("root", "teach", "V");
    TerminalKnoten er = new TerminalKnoten("affix", "er", "D");
    //Ebene 1
    NichtTerminalKnoten base2 = new NichtTerminalKnoten("base",new Knoten[] {teach, er});
    TerminalKnoten math = new TerminalKnoten("root", "math", "N");
    //Ebene 0
    NichtTerminalKnoten base1 = new NichtTerminalKnoten("base", new Knoten[] {math, base2});

    System.out.println(base1);
  }

  public static void main(String[] args) {
    //testTerminalKnoten();
    testNichtTerminalToString();
    testKnotenType();
  }
}
