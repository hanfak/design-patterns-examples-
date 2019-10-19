package iterator.exampleone;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Runner {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    printAllNumbersOldFor(numbers);
    printAllNumbersNewFor(numbers);
    printAllNumbersNewStreamsFor(numbers);
    printAllNumbersOldIterator(numbers);
  }

  private static void printAllNumbersNewStreamsFor(List<Integer> numbers) {
    numbers.forEach(System.out::println);
  }

  private static void printAllNumbersNewFor(List<Integer> numbers) {
    for (int number : numbers) {
      System.out.println(number);
    }
  }

  private static void printAllNumbersOldFor(List<Integer> numbers) {
    for (int i = 0; i < numbers.size(); i++) {
      System.out.println(numbers.get(i));
    }
  }

  private static void printAllNumbersOldIterator(List<Integer> numbers) {
    Iterator<Integer> iterator = numbers.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
