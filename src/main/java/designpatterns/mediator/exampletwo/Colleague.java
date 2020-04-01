package designpatterns.mediator.exampletwo;


public abstract class Colleague {

  private final Mediator mediator;

  public Colleague(Mediator m) {
    mediator = m;
  }

  //send a message via the mediator
  public void send(String message) {
    mediator.send(message, this);
  }

  //get access to the mediator
  public Mediator getMediator() {
    return mediator;
  }

  public abstract void receive(String message);
}
