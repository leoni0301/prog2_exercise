package elementutils;

public class ElementUtils {

  public static Object betterElement(Object object1, Object object2, TwoElementPredicate predicate) {
    return predicate.betterElement(object1, object2) ? object1 : object2;
  }
}
