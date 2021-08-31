package compsci.datastructures.binarytree.other;

//Summation of all nodes
public class Example01 {
  public static void main(String[] args) {
    BinaryTree1 a = new BinaryTree1();

    Node root = a.createNewNode(2);
    root.left = a.createNewNode(7);
    root.right = a.createNewNode(5);
    root.left.left = a.createNewNode(2);
    root.left.right = a.createNewNode(6);
    root.left.right.left = a.createNewNode(1);
    root.left.right.right = a.createNewNode(11);
    root.right.right = a.createNewNode(9);
    root.right.right.left = a.createNewNode(4);

    System.out.print("Total Sum: " + a.getSumOfNodes(root)); //54
  }
}

class BinaryTree1 {


  public int getSumOfNodes(Node node) {
    if (node == null) {
      return 0;
    }

    return node.data + getSumOfNodes(node.left) + getSumOfNodes(node.right);
//    Time complexity will be O(n), because we need to traverse n nodes, so that we can add all values.
//    Space complexity will be O(1), because we're not using any extra space other that recursion stack.
  }

  public Node createNewNode(int val) {
    Node newNode = new Node();
    newNode.data = val;
    newNode.left = null;
    newNode.right = null;
    return newNode;
  }
}