package functional.collectors.groupingby;


import functional.collectors.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class ExampleEight {

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

  public static void main(String... args) {
    System.out.println("\nExample 1");
    Map<Integer, List<String>> result = createPeople().stream()
            .collect(groupingBy(
                    Person::getAge,
                    mapping(
                            Person::getName,
                            toList())
            ));

    result.entrySet().forEach(System.out::println);

  }
}


