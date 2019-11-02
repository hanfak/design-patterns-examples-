package visitor.example2;

import java.util.Arrays;
import java.util.List;

public class Runner {
  public static void main(String... args) {
    List<Product> products = Arrays.asList(new Book(200), new Car(4000), new Book(205), new Book(303), new Wine(706));

    BasicPriceVisitor pricevisitor = new BasicPriceVisitor();

    products.forEach(x -> {
      x.accept(pricevisitor);
      int taxToPay = pricevisitor.taxToPay;
      System.out.println(x.getClass().getSimpleName());
      System.out.println("taxToPay = " + taxToPay);
    });
    int totalPrice = pricevisitor.totalPrice;
    System.out.println("BasicPriceVisitor totalPrice = " + totalPrice);
    System.out.println("\n\n");
    BasicPriceVisitor pricevisitor2 = new BasicPriceVisitor();

    products.forEach(x -> {
      x.accept(pricevisitor2);
      int taxToPay = pricevisitor2.taxToPay;
      System.out.println(x.getClass().getSimpleName());
      System.out.println("taxToPay = " + taxToPay);
    });
    int totalPricePricevisitor2 = pricevisitor2.totalPrice;
    System.out.println("BasicPriceVisitor totalPrice = " + totalPricePricevisitor2);
  }
}
