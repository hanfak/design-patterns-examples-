package functional.collectors.tomap;


import functional.collectors.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExampleOne {

  public static List<Person> createPeople() {
    return Arrays.asList(
            new Person("Sara", 20),
            new Person("Nancy", 22),
            new Person("Bob", 20),
            new Person("Paula", 32),
            new Person("Paul", 32),
            new Person("Jack", 3),
            new Person("Bill", 72),
            new Person("Jill", 11)
    );
  }
  // Create a map, with name as key
  public static void main(String... args) {
    Map<String, Person> result = createPeople().stream()
            .collect(Collectors.toMap(
                    Person::getName,
                    person -> person
            ));

    result.entrySet().forEach(System.out::println);
  }
}

