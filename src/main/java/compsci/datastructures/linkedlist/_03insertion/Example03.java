package compsci.datastructures.linkedlist._03insertion;


public class Example03 {
  public static void main(String[] args) {

    Node root = null;
    Linked a = new Linked();
    root = a.insertAtStart(root, 1);
    Linked.printList(root);
    root = a.insertAtStart(root, 2);
    Linked.printList(root);
    root = a.insertAtStart(root, 3);
    Linked.printList(root);
    root = a.insertAtStart(root, 4);
    Linked.printList(root);
    root = a.insertAtPosition(6, root, 77);
    Linked.printList(root);
    root = a.insertAtPosition(2, root, 88);
    Linked.printList(root);
  }
}
