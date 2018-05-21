public class KnotenTest {

  private static void validateType(Knoten knoten){
    if (knoten.getType() == "") {
      System.exit(0);
    }
  }

  private static void testType() {
    Knoten valid = new Knoten("bAse");
    validateType(valid);
    System.out.println("Der Typ ist gültig.");

    Knoten invalid = new Knoten("invalidType");
    validateType(invalid);
    System.out.println("Wenn dieser Text nicht ausgegeben wird, wurde das Programm beendet.");
  }

  private  static  void  testTerminalKnoten() {
    TerminalKnoten tKnoten = new TerminalKnoten("root", "math", "N");
    System.out.println(tKnoten.toString());
  }

  public static void main(String[] args) {
    testType();
    //testTerminalKnoten();
  }
}
