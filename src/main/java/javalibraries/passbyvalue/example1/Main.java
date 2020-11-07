package javalibraries.passbyvalue.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String... args) {
    List<String> aList = new ArrayList<>(Arrays.asList("one", "two"));
    BeanPoor beanPoor = new BeanPoor(aList);
    System.out.println("beanPoor = " + beanPoor.getCollection());
    aList.add("three");
    System.out.println("beanPoor after list outside has been modified = " + beanPoor.getCollection());

    List<String> aList1 = new ArrayList<>(Arrays.asList("one", "two"));
    BeanBetter beanBetter = new BeanBetter(aList1);
    System.out.println("beanPoor = " + beanBetter.getCollection());
    aList1.add("three");
    System.out.println("beanPoor after list outside has been modified = " + beanBetter.getCollection());
    System.out.println("List after being modified = " + aList1.stream().map(Object::toString).collect(Collectors.toList()));
  }

}
