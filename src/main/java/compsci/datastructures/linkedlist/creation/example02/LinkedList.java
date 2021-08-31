package compsci.datastructures.linkedlist.creation.example02;

public class LinkedList {

  Node head; // First element in list

  static class Node {

    int data;
    Node next;

    // Constructor to create a new node
    // Next is by default initialized as null
    Node(int data) {
      this.data = data;
    }
  }

  public static LinkedList insert(LinkedList list, int data) {
    // Create a new node with given data
    Node new_node = new Node(data);
    new_node.next = null;

    // If the Linked List is empty,
    // then make the new node as head
    if (list.head == null) {
      list.head = new_node;
    } else {
      // Else traverse till the last node
      // and insert the new_node there
      Node last = list.head;
      while (last.next != null) {
        last = last.next;
      }

      // Insert the new_node at last node
      last.next = new_node;
    }

    return list;
  }

  public static void printList(LinkedList list) {
    Node currNode = list.head;

    System.out.print("LinkedList: ");

    // Traverse through the LinkedList
    while (currNode != null) {
      // Print the data at current node
      System.out.print(currNode.data + " ");

      // Go to next node
      currNode = currNode.next;
    }
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    insert(list, 1);
    insert(list, 2);
    insert(list, 3);
    LinkedList partial = insert(list, 4);
    printList(partial);

    insert(list, 5);
    insert(list, 6);
    insert(list, 7);
    insert(list, 8);

    printList(list);
  }
}
