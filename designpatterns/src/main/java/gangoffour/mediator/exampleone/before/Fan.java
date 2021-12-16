package gangoffour.mediator.exampleone.before;

public class Fan {

  private final Button button;
  private final PowerSupplier powerSupplier ;
   boolean isOn = false;

  public Fan(Button button, PowerSupplier powerSupplier) {
    this.button = button;
    this.powerSupplier = powerSupplier;
  }

  // constructor, getters and setters

  public void turnOn() {
    powerSupplier.turnOn();
    isOn = true;
  }

  public void turnOff() {
    isOn = false;
    powerSupplier.turnOff();
  }

}
