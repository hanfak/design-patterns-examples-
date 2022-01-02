package datastructures.binarytree.other;

//total number of leaf nodes
public class Example03 {
  public static void main(String[] args) {
    BinaryTree3 a = new BinaryTree3();
    Node root = a.createNewNode(2);
    root.left = a.createNewNode(7);
    root.right = a.createNewNode(5);
    root.left.left = a.createNewNode(2);
    root.left.right = a.createNewNode(6);
    root.left.right.left = a.createNewNode(1);
    root.left.right.right = a.createNewNode(11);
    root.right.right = a.createNewNode(9);
    root.right.right.left = a.createNewNode(4);

    System.out.print("Total Nodes: " + a.getNumberOfLeafNodes(root));
  }
}


class BinaryTree3 {


  public int getNumberOfLeafNodes(Node node) {
    if (node == null) {
      return 0;
    }

    if(node.left == null && node.right == null) {
      return 1;
    }

    return getNumberOfLeafNodes(node.left) + getNumberOfLeafNodes(node.right);
  }

  public Node createNewNode(int val) {
    Node newNode = new Node();
    newNode.data = val;
    newNode.left = null;
    newNode.right = null;
    return newNode;
  }
}