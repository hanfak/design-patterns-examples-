package algorithms.binarygap;

import java.util.List;

import static java.util.Comparator.comparingInt;

public class _01Example {
  public static void main(String... args) {
    String input = "000010010001010001000001001000000";

    List<String> list = List.of(input.split("1"));
//    list.forEach(System.out::println);
    List<String> strings = list.subList(1, list.size() - 1);
//    strings.forEach(System.out::println);
    String result = strings.stream()
        .max(comparingInt(String::length))
        .orElse("none");
    System.out.println("result = " + result);

  }
}
