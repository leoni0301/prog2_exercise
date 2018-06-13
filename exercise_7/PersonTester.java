import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Iterator;


public class PersonTester {

  public static void main(String[] args) {
    MyDate d1 = null;
    MyDate d2 = null;
    MyDate d3 = null;
    MyDate d4 = null;
    MyDate d5 = null;

    try {
      d1 = new MyDate(4, 2, 2018);
      d2 = new MyDate(4, 2, 2017);
      d3 = new MyDate(1, 1, 1996);
      d4 = new MyDate(2, 2, 1996);
      d5 = new MyDate(3, 3, 1996);
    } catch (Exception e) {
      e.printStackTrace();
    }
    Name n1 = new Name("Doug", "Pederson");
    Name n2 = new Name("Trey", "Burton");
    Name n3 = new Name("Nicholas", "Edward", "Foles");
    Name n4 = new Name("Simon", "Busch");
    Name n5 = new Name("Leoni", "Moeske");
    Name n6 = new Name("Katharina", "Jablockin");

    Person p1 = new Person(n1, d1);
    Person p2 = new Person(n2, d1);
    Person p3 = new Person(n3, d2);
    Person p4 = new Person(n4, d3);
    Person p5 = new Person(n5, d4);
    Person p6 = new Person(n6, d5);

    ArrayList<Person> persons = new ArrayList<>();
    persons.add(p1);
    persons.add(p2);
    persons.add(p3);
    persons.add(p4);
    persons.add(p5);
    persons.add(p6);

    TreeMap<MyDate, HashSet<Person>> orderedPpl1 = new TreeMap<>();

    for (Person p : persons) {
      MyDate curBirth = p.getBirthday();

      if (orderedPpl1.containsKey(p.getBirthday())) {
        HashSet<Person> curPpl = orderedPpl1.get(curBirth);
        curPpl.add(p);
        orderedPpl1.put(curBirth, curPpl);
      } else {
        HashSet<Person> newPpl = new HashSet<>();
        newPpl.add(p);
        orderedPpl1.put(curBirth, newPpl);
      }
    }

    Iterator<MyDate> dateIter = orderedPpl1.keySet().iterator();
    while (dateIter.hasNext()) {
      MyDate curD = dateIter.next();
      HashSet<Person> curPpl = orderedPpl1.get(curD);
      Iterator<Person> pplIter = curPpl.iterator();
      while (pplIter.hasNext()) {
        System.out.println(pplIter.next());
      }
    }


    TreeMap<MyDate, TreeSet<Person>> orderedPpl2 = new TreeMap<>(new MonthDayComparator());
    for (Person p : persons) {
      MyDate curBirth = p.getBirthday();

      if (orderedPpl2.containsKey(p.getBirthday())) {
        TreeSet<Person> curPpl = orderedPpl2.get(curBirth);
        curPpl.add(p);
        orderedPpl2.put(curBirth, curPpl);
      } else {
        TreeSet<Person> newPpl = new TreeSet<>();
        newPpl.add(p);
        orderedPpl2.put(curBirth, newPpl);
      }
    }

    Iterator<MyDate> dateIter2 = orderedPpl2.keySet().iterator();
    while (dateIter2.hasNext()) {
      MyDate curD = dateIter2.next();
      TreeSet<Person> curPpl = orderedPpl2.get(curD);
      Iterator<Person> pplIter = curPpl.iterator();
      while (pplIter.hasNext()) {
        System.out.println(pplIter.next());
      }
    }

  }

}
