package functional.java7and8examples.currying;

public class CurryingPreJava8 {
    public static void main(String[] args) {
        System.out.println(calc(1).apply(2).apply(3).apply(4));
    }

    static Function<Integer, Function<Integer, Function<Integer, Integer>>> calc(final Integer a) {
        return new Function<Integer, Function<Integer, Function<Integer, Integer>>>() {
            @Override
            public Function<Integer, Function<Integer, Integer>>
            apply(final Integer b) {
                return new Function<Integer, Function<Integer, Integer>>() {
                    @Override
                    public Function<Integer, Integer>
                    apply(final Integer c) {
                        return new Function<Integer, Integer>() {
                            @Override
                            public Integer apply(Integer d) {
                                return (a + b) * (c + d);
                            }
                        };
                    }
                };
            }
        };
    }
}
