package compsci.datastructures.binarytree.other;

import java.util.LinkedList;

//is binary tree, a binary search tree
public class Example07 {
  public static void main(String[] args) {
    BinaryTree7 a = new BinaryTree7();
    Node root = a.createNewNode(12);
    root.left = a.createNewNode(7);
    root.left.left = a.createNewNode(6);
    root.left.left.left = a.createNewNode(2);
    root.left.right = a.createNewNode(9);
    root.left.right.left = a.createNewNode(8);
    root.right = a.createNewNode(24);
    System.out.println(a.isTreeBST(root));
    Node root2 = a.createNewNode(12);
    root2.left = a.createNewNode(7);
    root2.left.left = a.createNewNode(6);
    root2.left.left.left = a.createNewNode(2);
    root2.left.right = a.createNewNode(9);
    root2.left.right.left = a.createNewNode(8);
    root2.right = a.createNewNode(10);
    System.out.println(a.isTreeBST(root2));

  }
}


class BinaryTree7 {


  Node prev = null;

  public boolean isTreeBST(Node node) {
    if (node == null) {
      return true;
    }

    if (!isTreeBST(node.left)) {
      return false;
    }

    if (prev != null && node.data < prev.data) {
      return false;
    }

    prev = node;

    return isTreeBST(node.right);
  }


  public Node createNewNode(int val) {
    Node newNode = new Node();
    newNode.data = val;
    newNode.left = null;
    newNode.right = null;
    return newNode;
  }
}