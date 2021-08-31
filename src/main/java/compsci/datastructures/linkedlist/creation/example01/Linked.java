package compsci.datastructures.linkedlist.creation.example01;

public class Linked {
  Node root;

  public Linked() {
    root = null;
  }

  /*
   * getNewNode() method to generate a new node
   */
  public Node getNewNode(int key) {
    Node a = new Node();
    a.next = null;
    a.data = key;
    return a;
  }

  /*
   * insert method is used to insert the element in Linked List
   */
  public Node insert(Node node, int key) {
    if (node == null)
      return getNewNode(key);
    else
      node.next = insert(node.next, key);

    return node;
  }

  public static void printList(Node node) {
    if (node == null) {
      System.out.println();
      return;
    }

    System.out.print(node.data + "->");
    printList(node.next);
  }
}
