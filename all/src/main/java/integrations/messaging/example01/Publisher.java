package integrations.messaging.example01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Publisher<E> implements Runnable {

  private final Source<E> source;
  HashMap<String, List<Listener<E>>> listeners = new HashMap<>();

  public Publisher(Source<E> source) {
    this.source = source;
  }

  public synchronized void subscribe(String channel, Listener<E> listener) {
    listeners.putIfAbsent(channel, Arrays.asList(listener));
  }

  public synchronized void unsubscribe(String channel, Listener<E> listener) {
    List<Listener<E>> lst = listeners.get(channel);
    lst.remove(listener);
  }

  @Override
  public void run() {
    while (!Thread.interrupted()) {
      try {
        Pair<String, E> next = source.getNext();
        synchronized (this) {
          for (Listener<E> listener : listeners.get(next.second())) {
            listener.onEvent(next.second(), next.first());
          }
        }
      } catch (Throwable t) {
        //ignoring it
      }
    }
  }

}
