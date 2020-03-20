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

  public static List<functional.collectors.Person> createPeople() {
    return Arrays.asList(
            new functional.collectors.Person("Sara", 20),
            new functional.collectors.Person("Sara", 22),
            new functional.collectors.Person("Bob", 20),
            new functional.collectors.Person("Paula", 32),
            new functional.collectors.Person("Paul", 32),
            new functional.collectors.Person("Jack", 3),
            new functional.collectors.Person("Jack", 72),
            new functional.collectors.Person("Jill", 11),
            new Person("Jack", 32)
    );
  }
}
