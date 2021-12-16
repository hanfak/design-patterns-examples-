package gangoffour.visitor.example1;

import java.util.List;

import static java.util.Arrays.asList;

public class ShoppingCartClient {

  public static void main(String[] args) {
    List<ItemElement> items = asList(
            new Book(20, "1234", 15),
            new Book(100, "5678", 10),
            new Fruit(10, 2, "Banana"),
            new Fruit(5, 5, "Apple"));

    int total = calculatePrice(items);
    System.out.println("Total Cost = " + total);
  }

  private static int calculatePrice(List<ItemElement> items) {
    ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
    int sumOfItemPrices = items.stream().mapToInt(item -> item.accept(visitor)).sum();
    System.out.println("sumOfItemPrices = " + sumOfItemPrices);
    int sumOfFrieghtCostForSouthRegion = items.stream().mapToInt(item -> item.accept(new SouthRegionVisitor())).sum();
    System.out.println("sumOfFrieghtCostForSouthRegion = " + sumOfFrieghtCostForSouthRegion);
    return sumOfItemPrices + sumOfFrieghtCostForSouthRegion;
  }


}
