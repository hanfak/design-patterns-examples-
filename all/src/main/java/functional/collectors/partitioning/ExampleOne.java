package functional.collectors.partitioning;


import functional.collectors.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExampleOne {

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
  // split into even and odd age groups
  // Splits into two different groups
  public static void main(String... args) {
    Map<Boolean, List<Person>> result = createPeople().stream()
            .collect(Collectors.partitioningBy(
                    person -> person.getAge() % 2 == 0
            ));

    result.entrySet().forEach(System.out::println);
  }


  // Can do two streams which filters, and produces two lists, but not greate
}