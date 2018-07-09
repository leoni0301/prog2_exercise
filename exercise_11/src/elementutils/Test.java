package elementutils;

public class Test {
  public static void main(String[] args) {
    int result1 = (int) ElementUtils.betterElement(1, 3, (i, j) -> (int) i > (int) j);
    System.out.println(result1);

    String result2 = (String) ElementUtils.betterElement("blub", "bla", (i, j) -> ((String) i).length() < ((String) j).length());
    System.out.println(result2);

    boolean result3 = (boolean) ElementUtils.betterElement(true, false, (i, j) -> (boolean) i != (boolean) j);
    System.out.println(result3);
  }
}
