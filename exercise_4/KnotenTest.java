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
    //Ebene 4
    TerminalKnoten establish = new TerminalKnoten("root", "establish", "V");
    TerminalKnoten ment = new TerminalKnoten("affix", "ment", "D");
    //Ebene 3
    NichtTerminalKnoten base3 = new NichtTerminalKnoten("base",new Knoten[] {establish, ment});
    TerminalKnoten anti = new TerminalKnoten("affix", "anti", "D");
    //Ebene 2
    NichtTerminalKnoten base2 = new NichtTerminalKnoten("base", new Knoten[] {anti, base3});
    TerminalKnoten protest = new TerminalKnoten("root", "protest", "N");
    //Ebene 1
    NichtTerminalKnoten base1 = new NichtTerminalKnoten("base", new Knoten[] {base2, protest});
    TerminalKnoten s = new TerminalKnoten("affix", "s", "I");
    //Ebene 0
    NichtTerminalKnoten word = new NichtTerminalKnoten("word", new Knoten[] {base1, s});

    System.out.println(word);
  }

  public static void main(String[] args) {
    //testTerminalKnoten();
    testNichtTerminalToString();
    testKnotenType();
  }
}
