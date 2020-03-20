package functional.collectors.groupingby;


import functional.collectors.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingLong;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toUnmodifiableSet;

public class ExampleFive {

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

  // Splits into multiple different groups
  public static void main(String... args) {
    System.out.println("\nExample 1");
    Map<String, List<Integer>> result = createPeople().stream()
            // grouping by takes a function and collector
            .collect(Collectors.groupingBy(
                    Person::getName,
                    mapping(Person::getAge, Collectors.toList())
            ));

    result.entrySet().forEach(System.out::println);

    System.out.println("\nExample 2");
    Map<String, Set<Integer>> result1 = createPeople().stream()
            .collect(Collectors.groupingBy(
                    Person::getName, // the keys of the map
                    mapping(Person::getAge, // any type of transformation
                            toUnmodifiableSet()) // define what type of collector
            ));

    result1.entrySet().forEach(System.out::println);

    System.out.println("\nExample 3");
    Map<String, Long> result2 = createPeople().stream()
            .collect(Collectors.groupingBy(
                    Person::getName,
                    mapping(Person::getAge,
                            counting())
            ));

    result2.entrySet().forEach(System.out::println);

    System.out.println("\nExample 4");
    Map<String, Double> result3 = createPeople().stream()
            .collect(Collectors.groupingBy(
                    Person::getName,
                    mapping(Person::getAge,
                            averagingLong(num -> num))
            ));

    result3.entrySet().forEach(System.out::println);

    System.out.println("\nExample 5");
    Map<String, Float> result4 = createPeople().stream()
            .collect(Collectors.groupingBy(
                    Person::getName,
                    mapping(Person::getAge,
                            // Instead of counting to return some value, can map on the counts
                            Collectors.collectingAndThen(counting(),
                                    Long::floatValue))
            ));

    result4.entrySet().forEach(System.out::println);

//
//    System.out.println("\nExample 6");
//    Map<String, Double> result5 = createPeople().stream()
//            .collect(Collectors.groupingBy(
//                    Person::getName,
//                    mapping(Person::getAge,
//                            Collectors.)
//
//            ));
//
//    result5.entrySet().forEach(System.out::println);
  }
}


