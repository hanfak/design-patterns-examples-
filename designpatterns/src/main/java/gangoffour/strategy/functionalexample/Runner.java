package gangoffour.strategy.functionalexample;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static java.math.BigDecimal.valueOf;

public class Runner {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    System.out.println(totalAllValuesFunctionally(numbers));
    System.out.println(totalAllEvenValuesFunctionally(numbers));
    System.out.println(totalAllOddValuesFunctionally(numbers));

    System.out.println(totalAllValuesProcedural(numbers, 0));
    System.out.println(totalAllEvenValuesProcedural(numbers));
    System.out.println(totalAllOddValuesProcedural(numbers));

    // Higher order functions to pass designpatterns.gangoffour.strategy in
    System.out.println(totalAllValuesProceduralImproved(numbers, e -> true));
    System.out.println(totalAllValuesProceduralImproved(numbers, e -> e % 2 == 0));
    System.out.println(totalAllValuesProceduralImproved(numbers, e -> e % 2 != 0));

    System.out.println(totalAllValuesfunctionalImproved(numbers, e -> true));
    System.out.println(totalAllValuesfunctionalImproved(numbers, e -> e % 2 == 0));
    System.out.println(totalAllValuesfunctionalImproved(numbers, e -> e % 2 != 0));

    System.out.println(totalAllValuesAlternatefunctionalImproved(numbers, e -> true));
    System.out.println(totalAllValuesAlternatefunctionalImproved(numbers, e -> e % 2 == 0));
    System.out.println(totalAllValuesAlternatefunctionalImproved(numbers, e -> e % 2 != 0));

    // Passing in delegate method as high order concurrency.executearoundmethod.function
    System.out.println(totalAllValuesfunctionalImproved(numbers, Util::alwaysTrue));
    System.out.println(totalAllValuesfunctionalImproved(numbers, Util::isEven));
    System.out.println(totalAllValuesfunctionalImproved(numbers, e -> Util.isOdd(e)));

    Integer productResult = aggregateOfAllValues(numbers, 1, (a, b) -> a = a * b);
    System.out.println("productResult = " + productResult);
    Integer sumResult = aggregateOfAllValues(numbers, 0, (a, b) -> a = a + b);
    System.out.println("sumResult = " + sumResult);

    List<BigDecimal> numbers1 = Arrays.asList(BigDecimal.ONE,
            valueOf(2),
            valueOf(3),
            valueOf(4),
            valueOf(5),
            valueOf(6),
            valueOf(7),
            valueOf(8),
            valueOf(9),
            valueOf(10));
    BigDecimal sumResult1 = aggregateOfAllValues(numbers1, BigDecimal.ZERO, (a, b) -> a.add(b));
    System.out.println("sumResultofBigDec = " + sumResult1);
    BigDecimal productResult1 = aggregateOfAllValues(numbers1, BigDecimal.ONE, (a, b) -> a.multiply(b));
    System.out.println("productResultofBigDec = " + productResult1);
  }

  private static <T, S> S aggregateOfAllValues(List<T> values, S initial, BiFunction<T, S, S> aggregator) {
    S state = initial;
    for (T t : values) {
      state = aggregator.apply(t, state);
    }
    return state;
  }

  private static int totalAllValuesfunctionalImproved(List<Integer> numbers, Predicate<Integer> selector) {
    return numbers.stream().filter(selector).mapToInt(number -> number).sum();
  }

  private static int totalAllValuesAlternatefunctionalImproved(List<Integer> numbers, Predicate<Integer> selector) {
    return numbers.stream().filter(selector).reduce(0, Integer::sum);
  }

  private static Integer totalAllValuesFunctionally(List<Integer> numbers) {
    return numbers.stream().mapToInt(number -> number).sum();
  }

  private static Integer totalAllEvenValuesFunctionally(List<Integer> numbers) {
    return numbers.stream().filter(number -> number % 2 == 0).mapToInt(number -> number).sum();
  }

  private static Integer totalAllOddValuesFunctionally(List<Integer> numbers) {
    return numbers.stream().filter(number -> number % 2 != 0).mapToInt(number -> number).sum();
  }

  private static int totalAllValuesProceduralImproved(List<Integer> numbers, Predicate<Integer> selector) {
    int result = 0;

    for (int number : numbers) {
      if (selector.test(number)) {
        result += number;
      }
    }
    return result;
  }

  private static Integer totalAllValuesProcedural(List<Integer> numbers, int initial) {
    int result = initial;

    for (int number : numbers) {
      result += number;
    }
    return result;
  }

  private static Integer totalAllEvenValuesProcedural(List<Integer> numbers) {
    int result = 0;

    for (int number : numbers) {
      if (number % 2 == 0) {
        result += number;
      }
    }
    return result;
  }

  private static Integer totalAllOddValuesProcedural(List<Integer> numbers) {
    int result = 0;

    for (int number : numbers) {
      if (number % 2 != 0) {
        result += number;
      }
    }
    return result;
  }
}

class Util {
  public static boolean isEven(Integer number) {
    return number % 2 == 0;
  }

  public static boolean isOdd(Integer number) {
    return number % 2 != 0;
  }

  public static boolean alwaysTrue(Integer number) {
    return true;
  }
}

