package functional.collectors.groupingby;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ExampleOne {
  public static void main(String... args) {
    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    final int chunk = 5;
    AtomicInteger counter = new AtomicInteger();
    Map<Integer, List<Integer>> map = intList.stream()
            .collect(Collectors.groupingBy(i -> counter.getAndIncrement() / chunk));
    map.keySet().forEach(System.out::println);
    map.values().forEach(System.out::println);
  }
}
