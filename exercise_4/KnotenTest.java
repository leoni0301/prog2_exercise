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

  public static void main(String[] args) {
    testType();
  }
}
