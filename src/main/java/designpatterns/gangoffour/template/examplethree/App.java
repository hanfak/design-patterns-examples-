package designpatterns.gangoffour.template.examplethree;

public class App {

  public static void main(String... args) {
    OrderProcessTemplate netOrder = new NetOrder();
    netOrder.processOrder(true);
    System.out.println();
    OrderProcessTemplate storeOrder = new StoreOrder();
    storeOrder.processOrder(true);
    System.out.println();
    OrderProcessTemplate storeOrder1 = new StoreOrder();
    storeOrder1.processOrder(false);
  }
}
