package algorithms.binarysearch.deletenode;

import algorithms.binarysearch.helper.ExampleBST;
import algorithms.binarysearch.helper.Node;

public class Example01 {
    //time complexity = O(logn) height of tree
    public static void main(String... args) {
        Node bst = new ExampleBST().createBST();
        Node bst1 = new ExampleBST().createBST();
        Node delete = delete(bst, 6);
        System.out.println("delete = " + delete);
    }

    public static Node delete(Node node, int val) {
        if(node == null) return null;

        if (node.data == val) {
            // Case no children
            if (node.right == null && node.left == null) return null;
            //case 1 child
            if (node.left != null && node.right == null) return node.left;
            if (node.left == null) return node.right;
            // case 2 child
            Node anode = helper(node.right, node);
            node.data = anode.data;
        } else if (node.data < val) {
            node.right = delete(node.right, val);
        } else {
            node.left = delete(node.left, val);
        }
        return node;
    }

    private static Node helper(Node node, Node parent) {
        Node pre = parent;
        Node cur = node;
        while (cur.left !=null) {
            pre = cur;
            cur = cur.left;
        }
        delete(pre, cur.data);
        return cur;
    }

}
