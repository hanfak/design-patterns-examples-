package functional.flatmap;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ExampleOne {
  public static void main(String... args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    //one to one
    // If have one to one function, use map
    // stream<T> -> stream<R>
    System.out.println("Example 1");
    List<Integer> result = numbers.stream().map(e -> e * 2).collect(toList());

    result.forEach(System.out::println);


    // one to many
    // If have one to many function, use map
    // stream<T> -> stream<Collection<R>>
    System.out.println("\nExample 2");
    List<List<Integer>> result1 = numbers.stream()
            .map(e -> List.of(e - 1, e + 2))
            .collect(toList());

    result1.forEach(System.out::println);


    // one to many, but dont care about them being in separate collections
    // Which is two steps, map then flatten
    // If have one to many function, use flatmap
    // stream<T> -> stream<R>
    System.out.println("\nExample 3");
    List<Integer> result2 = numbers.stream()
            // flatmap needs an designpatterns.iterator ie stream, as it could be passed anything
            // ie set, list, so compiler will complain
            .flatMap(e -> List.of(e - 1, e + 2).stream())
            .collect(toList());

    result2.forEach(System.out::println);
  }
}
