package designpatterns.strategy.functionalexample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Runner {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    System.out.println(totalAllValuesFunctionally(numbers));
    System.out.println(totalAllEvenValuesFunctionally(numbers));
    System.out.println(totalAllOddValuesFunctionally(numbers));

    System.out.println(totalAllValuesProcedural(numbers));
    System.out.println(totalAllEvenValuesProcedural(numbers));
    System.out.println(totalAllOddValuesProcedural(numbers));

    // Higher order functions to pass designpatterns.strategy in
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
    if(selector.test(number)) {
      result += number;
    }
  }
  return result;
}

  private static Integer totalAllValuesProcedural(List<Integer> numbers) {
    int result = 0;

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

