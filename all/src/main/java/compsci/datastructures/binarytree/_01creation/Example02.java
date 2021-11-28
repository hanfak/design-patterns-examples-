package compsci.datastructures.binarytree._01creation;

public class Example02 {
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
  }

  public static class Node {
    int key;
    Node left, right;

    public Node(int item)
    {
      key = item;
      left = right = null;
    }
  }

  public static class BinaryTree {
    // Root of Binary Tree
    Node root;

    BinaryTree() { root = null; }

  }
}
