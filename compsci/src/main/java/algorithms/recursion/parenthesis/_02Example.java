package algorithms.recursion.parenthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _02Example {

    public static List<String> generateParenthesis(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();

        generate(n, stack, result, 0, 0);
        return result;
    }

    public static void generate(int required, Stack<String> stack, List<String> result, int numOpen, int numClosed) {
        if (numClosed == numOpen && numOpen + numClosed == required * 2) {
            result.add(String.join("", stack));
            return;
        }
        if (numClosed > numOpen || numOpen + numClosed == required * 2 || numOpen > required) {
            return;
        }
        if (numClosed < numOpen) {
            stack.add("(");
            generate(required, stack, result, numOpen + 1, numClosed);
            stack.pop();
        }
        if (numOpen < required) {
            stack.add(")");
            generate(required, stack, result, numOpen, numClosed + 1);
            stack.pop();
        }
    }

    public static void main(String... args) {

    }
}
