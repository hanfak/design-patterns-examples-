package functional.collectors.groupingby;


import functional.collectors.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExampleFour{

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
  // Splits into multiple different groups
  public static void main(String... args) {
    Map<Boolean, List<Person>> result = createPeople().stream()
            .collect(Collectors.groupingBy(
                    person -> person.getAge() % 2 == 0
            ));

    result.entrySet().forEach(System.out::println);

    Map<String, List<Person>> result1 = createPeople().stream()
            .collect(Collectors.groupingBy(
                    // By default this is grouped into a list
                    Person::getName 
            ));

    result1.entrySet().forEach(System.out::println);
  }


}


