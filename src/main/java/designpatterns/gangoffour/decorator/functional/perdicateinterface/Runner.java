package designpatterns.gangoffour.decorator.functional.perdicateinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Runner {

  static Predicate<Integer> isDivBy(int n) { return i -> (i % n) == 0;}

  public static void main(String... args) {
    Predicate<Integer> isOdd = e -> e % 2 != 0;
//    Predicate<Integer> isMultpleOfThree = e -> e % 3 == 0;
//    Predicate<Integer> isMultpleOfFive = e -> e % 5 == 0;
    Predicate<Integer> isMultpleOfThree = isDivBy(3);
    Predicate<Integer> isMultpleOfFive = isDivBy(5);

    System.out.println(isOdd.test(5));
    System.out.println(isOdd.test(9));

    System.out.println(isOdd.and(isMultpleOfThree).test(5));
    System.out.println(isOdd.and(isMultpleOfThree).test(9));

    System.out.println(isOdd.and(isMultpleOfThree).and(isMultpleOfFive).test(5));
    System.out.println(isOdd.and(isMultpleOfThree.or(isMultpleOfFive)).test(10));
    System.out.println(isOdd.negate().and(isMultpleOfThree.or(isMultpleOfFive)).test(10));

    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    numbers.stream().filter(isOdd.negate().and(isMultpleOfThree.or(isMultpleOfFive))).forEach(System.out::println);

    System.out.println("\nfizzbuzz demo\n");
    numbers.stream()
            .map(x -> {
              if(isMultpleOfThree.and(isMultpleOfFive).test(x)) {
                return "FizzBuzz";
              }
              if(isMultpleOfThree.test(x)) {
                return "Fizz";
              }
              if(isMultpleOfFive.test(x)) {
                return "Buzz";
              }
              return Integer.toString(x);
            })
            .forEach(System.out::println);

  }
}
