package functional.flatmap;

import functional.collectors.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleTwo {
  public static void main(String... args) {
    List<String> result = createPeople().stream()
            .map(Person::getName)
            .flatMap(name -> Stream.of(name.split("")))
            .collect(Collectors.toList());
    result.forEach(System.out::println);
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
            new Person("Jill", 11),
            new Person("Jack", 32)
    );
  }
}
