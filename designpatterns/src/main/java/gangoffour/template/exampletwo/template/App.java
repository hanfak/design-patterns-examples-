package gangoffour.template.exampletwo.template;

import java.util.Arrays;
import java.util.List;

public class App {
  public static void main(String... args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    Sum sum = new Sum(numbers);
    Integer sumResult = sum.evaluate();
    System.out.println("sumResult = " + sumResult);

    Product product = new Product(numbers);
    Integer productResult = product.evaluate();
    System.out.println("productResult = " + productResult);
  }
}
