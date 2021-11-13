package integrations.messaging.example01;

public class Subscriber<E> implements Listener<E> {

  private final String name;

  public Subscriber(String name, String channel, Publisher<E> publisher) {
    this.name = name;
    publisher.subscribe(channel, this);
  }

  @Override
  public void onEvent(final E channel, final String e) {
    System.out.println(name + ": received an event: " + e);
  }
}
