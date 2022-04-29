package functional.com.chapter2.methodreferences;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PersonExample {
    public static void main(String[] args) {
        // Can replace these variables in place of the function in the map
        // Both are the same
        Function<Person, String> getNameLambda = person -> person.getName();
        Function<Person, String> getNameMethRef = Person::getName;

        Stream<Person> personStream = Stream.of(new Person("Mike"), new Person("Maya"), new Person("Carl"));
        Stream<Person> personStreamTwo = Stream.of(new Person("Han"), new Person("Ban"), new Person("Can"));

        List<String> listOne = personStream
                .map(person -> person.getName())
                .collect(toList());
        System.out.println("listOne = " + listOne);

        List<String> ListTwo = personStreamTwo
                .map(Person::getName)
                .collect(toList());
        System.out.println("ListTwo = " + ListTwo);
    }
}

