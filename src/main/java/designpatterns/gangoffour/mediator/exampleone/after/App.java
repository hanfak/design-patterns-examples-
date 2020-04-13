package designpatterns.gangoffour.mediator.exampleone.after;

public class App {
  public static void main(String... args) {
    Button button = new Button();
    Fan fan = new Fan();
    PowerSupplier powerSupplier = new PowerSupplier();
    Mediator mediator = new Mediator();

    mediator.setButton(button);
    mediator.setFan(fan);
    mediator.setPowerSupplier(powerSupplier);

    button.press();
    System.out.println(fan.isOn());

    button.press();
    System.out.println(fan.isOn());

  }
}
