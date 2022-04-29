package functional.collectors.teeing;

import functional.collectors.Person;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class ExampleOne {
  // https://dzone.com/articles/java-12-the-teeing-collector
  public static void main(String... args) {
    System.out.println("\nExample 1");
    Map<String, Person> result = createPeople().stream()
            .collect(teeing(
                    maxBy(comparingInt(Person::getAge)),
                    minBy(comparingInt(Person::getAge)),
                    (e1, e2) -> {
                      Map<String, Person> map = new HashMap();
                      map.put("MAX", e1.get());
                      map.put("MIN", e2.get());
                      return map;
                    }
            ));

    result.entrySet().forEach(System.out::println);
  }

  public static List<Person> createPeople() {
    return Arrays.asList(
            new Person("Sara", 20),
            new Person("Sara", 22),
            new Person("Bob", 20),
            new Person("Paula", 32),
            new Person("Paul", 32),
            new Person("Jack", 3),
            new Person("Jack", 72),
            new Person("Jill", 11)
    );
  }

}
