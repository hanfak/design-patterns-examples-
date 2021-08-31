package compsci.datastructures.binarytree.other;

//max height from any node
public class Example04 {
  public static void main(String[] args) {
    BinaryTree4 a = new BinaryTree4();
    Node root = a.createNewNode(2);
    root.left = a.createNewNode(7);
    root.right = a.createNewNode(5);
    root.left.left = a.createNewNode(2);
    root.left.right = a.createNewNode(6);
    root.left.right.left = a.createNewNode(1);
    root.left.right.right = a.createNewNode(11);
    root.right.right = a.createNewNode(9);
    root.right.right.left = a.createNewNode(4);
    root.right.right.left.right = a.createNewNode(43);

    System.out.println("Total Nodes: " + a.getHeightOfTree(root));
    System.out.println("Total Nodes of left subtree: " + a.getHeightOfTree(root.left));
    System.out.println("Total Nodes of right subtree: " + a.getHeightOfTree(root.right));
  }
}


class BinaryTree4 {


  public int getHeightOfTree(Node node) {
    if (node == null) {
      return -1;
    }

    return Math.max(getHeightOfTree(node.left), getHeightOfTree(node.right)) + 1;
  }

  public Node createNewNode(int val) {
    Node newNode = new Node();
    newNode.data = val;
    newNode.left = null;
    newNode.right = null;
    return newNode;
  }
}