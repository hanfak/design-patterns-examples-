package gangoffour.template.exampletwo.better;

import java.util.Arrays;
import java.util.List;

public class App {
  public static void main(String... args) {
    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    Sum sum = new Sum();
    Integer sumResult = sum.evaluate(numbers);
    System.out.println("sumResult = " + sumResult);

    Product product = new Product();
    Integer productResult = product.evaluate(numbers);
    System.out.println("productResult = " + productResult);
  }
}
