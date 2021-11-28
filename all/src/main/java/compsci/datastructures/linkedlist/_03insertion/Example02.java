package compsci.datastructures.linkedlist._03insertion;


public class Example02 {
  public static void main(String[] args) {

    Node root = null;
    Linked a = new Linked();
    root = a.insertAtTail(root, 1);
    Linked.printList(root);
    root = a.insertAtTail(root, 2);
    Linked.printList(root);
    root = a.insertAtTail(root, 3);
    Linked.printList(root);
    root = a.insertAtTail(root, 4);
    Linked.printList(root);
  }
}
