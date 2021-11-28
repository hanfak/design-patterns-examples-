package functional.functionalinterfaces.effectivejava.unary;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Stream.iterate;

public class Unary {
  public static final String[] strings =
          { "a", "7", "4", "z", "T", "c", "10", "h", "2" };

  public static String createSomething() {
    return "abc";
  }

  public static void main(String[] args) {
    iterate(0, i -> i + 2); // use of uniary operator
    Optional<Integer> reduce = Stream.of(1, 2, 3, 4)
            .reduce((x, y) -> x + y); // binary operator
    reduce.orElseGet(() -> 5 * 5); // supplier
    reduce.orElseThrow(() -> new IllegalStateException("blabla")); // supplier - will not compute every time

    Stream.of(strings)
            .map(s -> s)
            .map(Function.identity()) // same as above line
            .filter(s -> s.matches("\\d+")) // predicate
            .map(Integer::parseInt) // function
            .forEach(System.out::println); // consumer - terminal

    VeryLongBusinessClassNameWithLotsOfOperations a = new VeryLongBusinessClassNameWithLotsOfOperations();
    iterate(0, i -> i + 1)
            .forEach(a::veryLongMethodThatCreatesAFactoryBasedOnInteger);
  }


}
