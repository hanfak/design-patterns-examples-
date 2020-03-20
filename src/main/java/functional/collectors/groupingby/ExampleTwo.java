package functional.collectors.groupingby;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExampleTwo {
  public static void main(String... args) {
    List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

    Map<String, List<Integer>> map = intList.stream()
            .collect(Collectors.groupingBy(i -> i % 2 != 0 ? "ODD" : "EVEN"));

    map.keySet().forEach(System.out::println);
    map.values().forEach(System.out::println);
  }
}
