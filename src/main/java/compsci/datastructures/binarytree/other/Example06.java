package compsci.datastructures.binarytree.other;

//max and min node
public class Example06 {
  public static void main(String[] args) {
    BinaryTree6 a = new BinaryTree6();
    Node root = a.createNewNode(8);
    root.left = a.createNewNode(3);
    root.right = a.createNewNode(10);
    root.left.left = a.createNewNode(1);
    root.left.right = a.createNewNode(6);
    root.left.right.left = a.createNewNode(4);
    root.left.right.right = a.createNewNode(7);
    root.right.right = a.createNewNode(14);
    root.right.right.left = a.createNewNode(13);

    a.findMinMaxValue(root);
    System.out.println(a.maximum);
    System.out.println(a.minimum);  }
}


class BinaryTree6 {


  int maximum = Integer.MIN_VALUE;
  int minimum = Integer.MAX_VALUE;

  public void findMinMaxValue(Node node) {
    if (node == null) {
      return;
    }

    if (node.data > maximum) {
      maximum = node.data;
    }

    if (node.data < minimum) {
      minimum = node.data;
    }

    findMinMaxValue(node.left);
    findMinMaxValue(node.right);
  }


  public Node createNewNode(int val) {
    Node newNode = new Node();
    newNode.data = val;
    newNode.left = null;
    newNode.right = null;
    return newNode;
  }
}