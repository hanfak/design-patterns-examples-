package compsci.datastructures.binarytree._02traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Example03 {
  static List<Node> result = new ArrayList<>();

  public static void main(String[] args) {
    Node binaryTree = createBinaryTree();

    List<Node> depthFirstIterative = depthFirstIterative(binaryTree);
    depthFirstIterative.stream().map(x -> x.data).forEach(System.out::println);
    System.out.println();
    depthFirstRecursive(binaryTree);
    System.out.println();
    List<Node> nodes = depthFirstRecursive2(binaryTree);
    nodes.stream().map(x -> x.data).forEach(System.out::println);
    result.clear();


  }

  private static List<Node> breadthFirstIterative(Node binaryTree) {
    Stack<Node> stack = new Stack<>();
    stack.push(binaryTree);
    List<Node> result = new ArrayList<>();
    while (!stack.empty()) {
      Node current = stack.pop();
      result.add(current);
      if (current.left != null) stack.push(current.left);
      if (current.right != null) stack.push(current.right);
    }
    return result;
  }

  private static void depthFirstRecursive(Node binaryTree) {
    if (binaryTree == null) return;
    String data = binaryTree.data;
    System.out.println(data);

    depthFirstRecursive(binaryTree.right);
    depthFirstRecursive(binaryTree.left);
  }

  private static List<Node> depthFirstRecursive2(Node binaryTree) {
    if (binaryTree != null) helperRecursive2(binaryTree);
    return result;
  }

  private static void helperRecursive2(Node binaryTree) {
    result.add(binaryTree);
    if (binaryTree.right != null) helperRecursive2(binaryTree.right);
    if (binaryTree.left != null) helperRecursive2(binaryTree.left);
  }

  private static List<Node> depthFirstIterative(Node binaryTree) {
    Stack<Node> stack = new Stack<>();
    stack.push(binaryTree);
    List<Node> result = new ArrayList<>();
    while (!stack.empty()) {
      Node current = stack.pop();
      result.add(current);
      if (current.left != null) stack.push(current.left);
      if (current.right != null) stack.push(current.right);
    }
    return result;
  }


  private static Node createBinaryTree() {
    Node a = new Node("a");
    Node b = new Node("b");
    Node c = new Node("c");
    Node d = new Node("d");
    Node e = new Node("e");
    Node f = new Node("f");
    Node g = new Node("g");
    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.right = f;
    f.left = g;
    return a;
  }
}