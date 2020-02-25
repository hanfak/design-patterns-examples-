package functional.java7and8examples.currying;

public class CurryingPostJava8 {
    public static void main(String[] args) {
        System.out.println(calc(1).apply(2).apply(3).apply(4));
        System.out.println(calc2(1).apply(2).apply(3).apply(4));
    }

    // Using intellij
    static Function<Integer, Function<Integer, Function<Integer, Integer>>> calc(final Integer a) {
        return b -> (Function<Integer, Function<Integer, Integer>>) c
                -> (Function<Integer, Integer>) d
                -> (a + b) * (c + d);
    }

    static Function<Integer, Function<Integer, Function<Integer, Integer>>> calc2(Integer a) {
        return b -> c -> d -> (a + b) * (c + d);
    }
}

/**
 * f(a, b, c, d) = (a + b) * (c + d)
 * f(1, b, c, d) = g(b, c, d) = (1 + b) * (c + d)
 * g(2, c, d) = h(c, d) = (1 + 2) * (c + d)
 * h(3, d) = i(d) = (1 + 2) * (3 + d)
 * i(4) = (1 + 2) * (3 + 4)
 * <p>
 * Because currying is about performing partial application of a function,
 * it doesn't matter in what order the arguments are applied
 */