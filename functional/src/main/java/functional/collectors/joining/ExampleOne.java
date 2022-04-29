package functional.collectors.joining;


import functional.collectors.Person;

import java.util.Arrays;
import java.util.List;
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
  // Combine list, into comma separated string
  public static void main(String... args) {
    String result = createPeople().stream()
            .filter(person -> person.getAge() > 30)
            .map(Person::getName)
            .map(String::toUpperCase)
            .collect(Collectors.joining(", "));

    System.out.println("result = " + result);
  }
}