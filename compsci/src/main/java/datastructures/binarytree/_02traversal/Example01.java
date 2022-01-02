package datastructures.binarytree._02traversal;


// Trees have multiple ways to traverse them
public class Example01 {
  public static void main(String[] args) {
    BinaryTree a = new BinaryTree();

    IntegerNode root = a.createNewNode(2);
    root.left = a.createNewNode(7);
    root.right = a.createNewNode(5);
    root.left.left = a.createNewNode(3);
    root.left.right = a.createNewNode(6);
    root.left.right.left = a.createNewNode(1);
    root.left.right.right = a.createNewNode(11);
    root.right.right = a.createNewNode(9);
    root.right.right.left = a.createNewNode(4);

    System.out.print("Inorder: ");
    a.inorder(root);
    System.out.println();

    System.out.print("PreOrder: ");
    a.preorder(root);
    System.out.println();

    System.out.print("PostOrder: ");
    a.postorder(root);
    System.out.println();
  }
}

class BinaryTree {

  public IntegerNode createNewNode(int val) {
    IntegerNode newNode = new IntegerNode(val);
    newNode.left = null;
    newNode.right = null;
    return newNode;
  }

  // Left, Root, Right
  // print all sorted elements in bst
  public void inorder(IntegerNode node) {
    if (node == null) {
      return;
    }

    inorder(node.left);
    System.out.print(node.data + " ");
    inorder(node.right);
  }

  //Root, Left, Right
  //Preorder traversal is used to create a copy of the tree. Preorder traversal is also used to get prefix expression on of an expression tree.
  public void preorder(IntegerNode node) {
    if (node == null) {
      return;
    }

    System.out.print(node.data + " ");
    preorder(node.left);
    preorder(node.right);
  }

  // Left, Right, Root
  //Postorder traversal is used to delete the tree
  public void postorder(IntegerNode node) {
    if (node == null) {
      return;
    }

    postorder(node.left);
    postorder(node.right);
    System.out.print(node.data + " ");
  }
}