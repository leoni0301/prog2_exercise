package elementutils;

public class Test {
  public static void main(String[] args) {
    // pred1 checks whether an integer object is bigger than another
    TwoElementPredicate pred1 = (i, j) -> (int) i > (int) j;
    int result1 = (int) ElementUtils.betterElement(1, 3, pred1);
    System.out.println(result1);

    // pred2 checks whether a string object is shorter than another
    TwoElementPredicate pred2 = (i, j) -> ((String) i).length() < ((String) j).length();
    String result2 = (String) ElementUtils.betterElement("blub", "bla", pred2);
    System.out.println(result2);

    // pred3 checks whether a boolean object is the same as another
    TwoElementPredicate pred3 = (i, j) -> (boolean) i != (boolean) j;
    boolean result3 = (boolean) ElementUtils.betterElement(true, false, pred3);
    System.out.println(result3);
  }
}
