package functional.com.chapter2.methodreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerExample {
    public static void main(String[] args) {
        List<Person> linuxUsers = new ArrayList<>();
        System.out.println("linuxUsers = " + linuxUsers);

        Consumer<Person> addUserLambda = person -> linuxUsers.add(person);
        Consumer<Person> addUserMethRef = linuxUsers::add;

        Stream.of(new Person("Mike"), new Person("Maya"), new Person("Carl"))
                .forEach(person -> linuxUsers.add(person));

        System.out.println("linuxUsers1 = " + linuxUsers);
        linuxUsers.stream().map(person -> person.getName()).forEach(System.out::println);

        Stream.of(new Person("Mike"), new Person("Maya"), new Person("Carl"))
                .forEach(linuxUsers::add);
        System.out.println("linuxUsers2 = " + linuxUsers);

        System.out.println("Another example");
        Consumer<Integer> consumer = i -> System.out.print(" " + i);
        Consumer<Integer> consumerWithAndThen = consumer.andThen( i-> System.out.print("(printed "+i+")"));
        List<Integer> integerList = Arrays.asList(1, 10, 200, 101, -10, 0);
        printList(integerList, consumer);
        System.out.println("\nand then");
        printList(integerList, consumerWithAndThen);
    }

    public static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer){
        for(Integer integer : listOfIntegers){
            consumer.accept(integer);
        }
    }

}
