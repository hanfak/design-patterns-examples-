package other.queue;

import java.util.Arrays;

public class QueueImpl {
  private  String[] queue;
  private final int size;
  private int firstElement = 0;
  private int lastElement = 0;

  public QueueImpl(int size) {
    this.size = size - 1;
    this.queue = new String[this.size];
  }

  public void enqueue(String element) {
    if (size == lastElement) {
      throw new IllegalStateException("Queue is full");
    }

    queue[lastElement] = element;
    lastElement++;
  }

  public String dequeue() {
    if (queue[firstElement] == null) {
      throw new IllegalStateException("Empty queue");
    }

    String s = queue[firstElement];
    // Move all element one place up
    String[] strings = Arrays.copyOfRange(queue, 1, 9);
    queue = Arrays.copyOf(strings, size);
    return s;
  }

  public void listAllElements() {
    for (int i = 0; i < size ; i++) {
      if(queue[i] != null) {
        System.out.println(queue[i]);
      }
    }
  }


  public static void main(String... args) {
    QueueImpl queue = new QueueImpl(10);
    queue.enqueue("Hello");
    queue.enqueue("Hello");

    queue.listAllElements();

  }
}
