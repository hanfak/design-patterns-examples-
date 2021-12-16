package gangoffour.mediator.exampleone.before;

public class Button {
  private final Fan fan;

  public Button(Fan fan) {
    this.fan = fan;
  }

  public void press(){
    if(fan.isOn){
      fan.turnOff();
    } else {
      fan.turnOn();
    }
  }
}
