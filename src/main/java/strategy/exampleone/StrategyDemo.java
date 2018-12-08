package strategy.exampleone;

import java.util.ArrayList;
import java.util.List;

public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234", 10);
        Item item2 = new Item("5678", 40);

        cart.addItem(item1);
        cart.addItem(item2);

        // pay by paypal
        cart.pay(new PaypalStrategy("myemail@example.com", "mypwd"));

        // pay by credit card
        cart.pay(new CreditCardStrategy("Pankaj Kumar", "1234567890123456", "786", "12/15"));
        System.out.println();
        cart.payNonStrategy("credit card");
        cart.payNonStrategy("paypal");
    }
}

interface PaymentStrategy {
    public void pay(int amount);
}

class CreditCardStrategy implements PaymentStrategy {

    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate) {
        this.name = nm;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit/debit card");
    }

}

class PaypalStrategy implements PaymentStrategy {

    private String emailId;
    private String password;

    public PaypalStrategy(String email, String pwd) {
        this.emailId = email;
        this.password = pwd;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Paypal.");
    }

}

class Item {

    private String upcCode;
    private int price;

    public Item(String upc, int cost) {
        this.upcCode = upc;
        this.price = cost;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public int getPrice() {
        return price;
    }

}

class ShoppingCart {

    List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<Item>();
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
        switch(paymentStrategy) {
            case "paypal":
                System.out.println(calculateTotal() + " paid using Paypal.");
                break;
            case "credit card":
                System.out.println(calculateTotal() + " paid with credit/debit card");
                break;
        }
        throw new IllegalArgumentException();
    }

    //factory method
    public void payNonStrategy2(String paymentStrategy) {
        switch(paymentStrategy) {
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
