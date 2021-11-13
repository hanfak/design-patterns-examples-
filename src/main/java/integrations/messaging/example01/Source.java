package integrations.messaging.example01;

public interface Source<E> {
  Pair<String, E> getNext();

}
