package algorithms.recursion.parenthesis;

import java.util.ArrayList;
import java.util.List;

public class _04Example {

    public static List<String> generateParenthesis(int n) {
        StringBuilder stack = new StringBuilder();
        List<String> result = new ArrayList<>();

        generate(n, stack, result, 0, 0);
        return result;
    }

    public static void generate(int required, StringBuilder stack, List<String> result, int numOpen, int numClosed) {
        if (stack.length() == required * 2) {
            result.add(stack.toString());
            return;
        }
        if (numOpen < required) {
            stack.append('(');
            generate(required, stack, result, numOpen + 1, numClosed );
            stack.setLength(stack.length() - 1);

        }
        if (numClosed < numOpen) {
            stack.append(')');
            generate(required, stack, result, numOpen, numClosed + 1);
            stack.setLength(stack.length() - 1);

        }
    }

    public static void main(String... args) {
        List<String> strings = generateParenthesis(3);
        System.out.println("strings = " + strings);
    }
}
