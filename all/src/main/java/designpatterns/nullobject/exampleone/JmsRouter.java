package designpatterns.nullobject.exampleone;

public class JmsRouter implements Router {

  @Override
  public void route(Message msg) {
    System.out.println("Routing to a JMS queue. Msg: " + msg);
  }

}

