package functional.collectors.groupingby;


import functional.collectors.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

public class ExampleSix {

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
    Optional<Person> result = createPeople().stream()
            .collect(maxBy(comparingInt(Person::getAge)));

    System.out.println("result = " + result.get());

    // Same as example 1
    System.out.println("\nExample 2");
    Optional<Person> result2 = createPeople().stream()
            .max(comparingInt(Person::getAge));

    System.out.println("result = " + result2.get());

    System.out.println("\nExample 3");
    Optional<Person> result3 = createPeople().stream()
            .collect(minBy(comparingInt(Person::getAge)));

    System.out.println("result = " + result3.get());

    // Avoids handling the optional as above
    System.out.println("\nExample 4");
    String result4 = createPeople().stream()
            .collect(collectingAndThen(
                    maxBy(comparingInt(Person::getAge)),
                    optionalPerson -> optionalPerson
                            .map(Person::getName)
                            .orElse("")
            ));

    System.out.println("result = " + result4);
  }
}


