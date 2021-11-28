package integrations.messaging.example01;

public interface Listener<E> {
  void onEvent(E channel, String e);
}
