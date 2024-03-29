package gangoffour.template.exampletwo.better;

import java.util.Arrays;
import java.util.List;

public class App2 {
  public static void main(String... args) {
    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    Integer sum = numbers.stream().reduce(0, Integer::sum);
    System.out.println("sum = " + sum);
    Integer product = numbers.stream().reduce(1, (a, b) -> a * b);
    System.out.println("product = " + product);
  }
}
