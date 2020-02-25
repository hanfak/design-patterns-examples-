package functional.java7and8examples.lazyevaluation;

public class LazyEvaluationPostJava8 {
    public static void main(String[] args) {

        Function<Integer, Integer> square = x -> {
            System.out.println("in square");

            return x * x;
        };

        Function<Integer, Integer> cube = x -> {
            System.out.println("in cube");

            return x * x * x;
        };

        System.out.printf("%d%n", ifThenElse(true, square, cube, 4));
        System.out.printf("%d%n", ifThenElse(false, square, cube, 4));
    }

    private static <T, R> R ifThenElse(boolean predicate,
                                       Function<T, R> onTrue,
                                       Function<T, R> onFalse,
                                       T t) {
        return (predicate ? onTrue.apply(t) : onFalse.apply(t));
    }
}
