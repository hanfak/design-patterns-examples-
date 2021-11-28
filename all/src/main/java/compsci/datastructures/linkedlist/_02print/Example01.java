package compsci.datastructures.linkedlist._02print;

public class Example01 {
  public static void main(String[] args) {

    Node root = null;
    Linked a = new Linked();
    root = a.insert(root, 1);
    Linked.printList(root);
    root = a.insert(root, 2);
    Linked.printList(root);
    root = a.insert(root, 3);
    Linked.printList(root);
    root = a.insert(root, 4);
    Linked.printList(root);
  }
}
