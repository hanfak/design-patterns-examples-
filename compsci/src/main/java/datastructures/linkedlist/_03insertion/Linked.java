package datastructures.linkedlist._03insertion;

public class Linked {
  Node root;
  Node tail;

  public Linked() {
    root = null;
    tail = null;
  }

  public static void printList(Node node) {
    if (node == null) {
      System.out.println();
      return;
    }
    while (node != null) {
      System.out.print(node.data + " -> ");
      node = node.next;
    }
    System.out.println();
  }

  // TC = O(n)
  // Can reduce TC by storing a pointer to the last element
  public Node insertAtTail(Node list, int data) {
    Node node = new Node(data);
    Node tmp = list;
    if (tmp == null) {
      return node;
    }
    while (tmp.next != null) {
      tmp = tmp.next;
    }
    tmp.next = node;
    return list;
  }


  // TC = O(1)
  public Node insertAtStart(Node list, int data) {
    Node node = new Node(data);
    if (list == null) {
      return node;
    }
    node.next = list;
    return node;
  }

  // O(n) > TC > O(1)

  public Node insertAtPosition(int position, Node root, int data) {
    if (position < 0) {
      System.out.println("Position can't be less than 1");
      return root;
    }
    if (root == null && position > 1) {
      System.out.println("Position is greater than element exists");
      return root;
    }
    if (root == null && position == 1) {
      return new Node(data);
    }
    if (position == 1) {
      Node newNode = new Node(data);
      newNode.next = root;
      return newNode;
    }
    root.next = insertAtPosition(position - 1, root.next, data);
    return root;
  }

  public Node insertAtPosition1(int position, Node root, int data) {
    Node newNode = new Node(data);
    Node current = root;
    if (position == 0 ){
      newNode.next = root;
      return newNode;
    }
    int index = 0;
    while (index < position - 1) {
      current = current.next;
      index++;
    }
    // Take node from list at position and append (let new node point to) it to new node
    newNode.next = current.next;
    // Take node before position new node will be, then point to new node
    current.next = newNode;
    return root;
  }


  }
