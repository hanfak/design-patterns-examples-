package compsci.datastructures.linkedlist._02print;

public class Linked {
  Node root;

  public Linked() {
    root = null;
  }


  public static void printList(Node node) {
    if (node == null) {
      System.out.println();
      return;
    }
    while(node != null) {
      System.out.print(node.data + " -> ");
      node = node.next;
    }
    System.out.println();
  }

  public Node getNewNode(int key) {
    Node a = new Node(key);
    a.next = null;
    a.data = key;
    return a;
  }

  public Node insert(Node node, int key) {
    if (node == null)
      return getNewNode(key);
    else
      node.next = insert(node.next, key);

    return node;
  }
}
