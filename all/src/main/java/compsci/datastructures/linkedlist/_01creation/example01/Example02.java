package compsci.datastructures.linkedlist._01creation.example01;
// iteration
public class Example02 {
  public static void main(String[] args) {

    LinkedList obj = new LinkedList();
    Node head = null;

    head = obj.insert(head, 12);
    head = obj.insert(head, 7);
    head = obj.insert(head, 8);
    head = obj.insert(head, 10);

    obj.printList(head);

  }
}
class LinkedList {

  private Node getNewNode(int val) {
    Node newNode = new Node();
    newNode.data = val;
    newNode.next =  null;

    return newNode;
  }

  public Node insert(Node node, int val) {
    if(node == null) {
      return getNewNode(val);
    }

    Node firstNode = node;

    while(node.next != null) {
      node = node.next;
    }

    node.next = getNewNode(val);
    return firstNode;
  }

  public void printList(Node node) {
    if(node == null) {
      return;
    }

    while(node != null) {
      System.out.print(node.data + " ");

      node = node.next;
    }
  }
}
