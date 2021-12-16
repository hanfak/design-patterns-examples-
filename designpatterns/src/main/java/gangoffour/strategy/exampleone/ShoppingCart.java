package gangoffour.strategy.exampleone;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

  final List<Item> items;

  public ShoppingCart() {
    this.items = new ArrayList<>();
  }

  public void addItem(Item item) {
    this.items.add(item);
  }

  public void removeItem(Item item) {
    this.items.remove(item);
  }

  public int calculateTotal() {
    return items.stream().map(Item::getPrice).reduce(0, Integer::sum);
  }

  public void pay(PaymentStrategy paymentMethod) {
    paymentMethod.pay(calculateTotal());
  }


  public void payNonStrategy(String paymentStrategy) {
    switch (paymentStrategy) {
      case "paypal":
        System.out.println(calculateTotal() + " paid using Paypal.");
        break;
      case "credit card":
        System.out.println(calculateTotal() + " paid with credit/debit card");
        break;
    }
    throw new IllegalArgumentException();
  }

  //designpatterns.gangoffour.factory method
  public void payNonStrategy2(String paymentStrategy) {
    switch (paymentStrategy) {
      case "paypal":
        new PaypalStrategy(null, null).pay(calculateTotal());
        break;
      case "credit card":
        new CreditCardStrategy(null, null, null, null).pay(calculateTotal());
        break;
    }
    throw new IllegalArgumentException();
  }

}
