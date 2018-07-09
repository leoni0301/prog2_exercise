package elementutils;

public class Test {
  public static void main(String[] args) {
    // int 1 größer int 2 ?
    TwoElementPredicate pred1 = (i, j) -> (int) i > (int) j;
    int result1 = (int) ElementUtils.betterElement(1, 3, pred1);
    System.out.println(result1);

    // string 1 kürzer string 2 ?
    String result2 = (String) ElementUtils.betterElement("blub", "bla", (i, j) -> ((String) i).length() < ((String) j).length());
    System.out.println(result2);

    // bool 1 ungleich bool 2 ?
    boolean result3 = (boolean) ElementUtils.betterElement(true, false, (i, j) -> (boolean) i != (boolean) j);
    System.out.println(result3);
  }
}
