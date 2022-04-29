package functional.collectors.groupingby;


import functional.collectors.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class ExampleNine {

  public static void main(String... args) {
    System.out.println("\nExample 1");
    Map<Integer, List<String>> result = createPeople().stream().collect(
            groupingBy(
                    Person::getAge,
                    flatMapping(
                            person -> Stream.of(person.getName().split("")),
                            toList()
                    )
            )
    );

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


