package functional.collectors.reducing;

import functional.collectors.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleOne {

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
  // Very verbose reduce function
  public static void main(String... args) {
    ArrayList<String> result = createPeople().stream()
            .filter(person -> person.getAge() > 30)
            .map(Person::getName)
            .map(String::toUpperCase)
            // This can be done via the Collectors api
            .reduce(
                    new ArrayList<>(),
                    (names, name) -> {
                      names.add(name); // Local mutablitiy, nothing shared globally is affected
                      return names;
                    },
                    // How to collect the sub objects, when it is executed in parallel
                    (names1, names2) -> {
                      names1.addAll(names2);
                      return names1;
                    }
            );
    result.forEach(System.out::println);
  }
}

