package designpatterns.gangoffour.mediator.exampleone.after;

public class Button {
  private Mediator mediator;

  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }

  public void press() {
    this.mediator.press();
  }
}
