package algorithms.recursion.parenthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _03Example {

    public static List<String> generateParenthesis(int n) {
        String stack = "";
        List<String> result = new ArrayList<>();

        generate(n, stack, result, 0, 0);
        return result;
    }

    public static void generate(int required, String stack, List<String> result, int numOpen, int numClosed) {
        if (stack.length() == required * 2) {
            result.add(stack);
            return;
        }
        if (numOpen < required) {
            generate(required, stack + "(", result, numOpen + 1, numClosed );

        }
        if (numClosed < numOpen) {
            generate(required, stack + ")", result, numOpen, numClosed + 1);
        }
    }

    public static void main(String... args) {
        List<String> strings = generateParenthesis(8);
        System.out.println("strings.size() = " + strings.size());
        System.out.println("strings = " + strings);
    }
}
