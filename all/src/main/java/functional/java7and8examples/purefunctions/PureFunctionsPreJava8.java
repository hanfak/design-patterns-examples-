package functional.java7and8examples.purefunctions;


import java.util.function.Function;

public class PureFunctionsPreJava8 {
    public static void main(String[] args) {
        Function<Integer, Integer> dim = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer month) {
                return new Integer[]{31, 28, 31, 30, 31, 30,
                        31, 31, 30, 31, 30, 31}[month];
            }
        };
        System.out.printf("April: %d%n", dim.apply(3));
        System.out.printf("August: %d%n", dim.apply(7));
    }
}
