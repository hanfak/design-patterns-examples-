package compsci.datastructures.linkedlist._01creation.example03;

public class LinkedList {
  private static int counter;
  private Node head;

  // appends the specified element to the end of this list.
  public LinkedList add(Object data) {

    // Initialize Node only incase of 1st element
    if (head == null) {
      head = new Node(data);
    }

    Node temp = new Node(data);
    Node current = head;

    // Let's check for NPE before iterate over current
    if (current != null) {

      // starting at the head node, crawl to the end of the list and then add element after last node
      while (current.getNext() != null) {
        current = current.getNext();
      }

      // the last node's "next" reference set to our new node
      current.setNext(temp);
    }

    // increment the number of elements variable
    incrementCounter();
    return this;
  }

  public int size() {
    return getCounter();
  }

  public String toString() {
    String output = "";

    if (head != null) {
      Node current = head.getNext();
      while (current != null) {
        output += "[" + current.getData().toString() + "]";
        current = current.getNext();
      }

    }
    return output;
  }

  private static void incrementCounter() {
    counter++;
  }

  private static int getCounter() {
    return counter;
  }
}
