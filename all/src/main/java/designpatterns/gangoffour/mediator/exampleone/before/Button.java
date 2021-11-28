package designpatterns.gangoffour.mediator.exampleone.before;

import designpatterns.gangoffour.mediator.exampleone.after.Fan;

public class Button {
  private Fan fan = new Fan();

  public Button(Fan fan) {
    this.fan = fan;
  }

  public void press(){
    if(fan.isOn()){
      fan.turnOff();
    } else {
      fan.turnOn();
    }
  }
}
