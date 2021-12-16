package gangoffour.strategy.exampleone;

public class PaypalStrategy implements PaymentStrategy {

  private final String emailId;
  private final String password;

  public PaypalStrategy(String email, String pwd) {
    this.emailId = email;
    this.password = pwd;
  }

  @Override
  public void pay(int amount) {
    System.out.println(amount + " paid using Paypal.");
  }

}
