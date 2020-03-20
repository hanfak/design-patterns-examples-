package functional.collectors.groupingby;


import functional.collectors.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class ExampleSeven {

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

    System.out.println("\nExample 2");
    Map<Integer, List<String>> result1 = createPeople().stream()
            .collect(groupingBy(
                    Person::getAge,
                    mapping(
                            Person::getName,
                            filtering(
                                    name -> name.length() > 4,
                                    toList()))
            ));

    result1.entrySet().forEach(System.out::println);

    System.out.println("\nExample 3");
    Map<Integer, List<Person>> result2 = createPeople().stream()
            .collect(groupingBy(
                    Person::getAge,
                    filtering(
                            person -> person.getAge() > 30,
                            toList()))
            );

    result2.entrySet().forEach(System.out::println);


    System.out.println("\nExample 4");
    Map<Integer, List<String>> result3 = createPeople().stream()
            .collect(groupingBy(
                    Person::getAge,
                    filtering(
                            person -> person.getAge() > 30,
                            mapping(
                                    Person::getName,
                                    toList()
                            )))
            );

    result3.entrySet().forEach(System.out::println);

    System.out.println("\nExample 5");
    Map<String, List<Integer>> result4 = createPeople().stream()
            .collect(groupingBy(
                    Person::getName,
                    filtering(
                            person -> person.getAge() > 30,
                            mapping(
                                    Person::getAge,
                                    toList()
                            )))
            );

    result4.entrySet().forEach(System.out::println);
  }
}


