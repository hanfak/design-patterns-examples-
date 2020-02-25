package functional.java7and8examples.cloures;


public class ClosuresPreJava8 {
    Function<Integer, Integer> add(final int x) {
        //An anonymous inner class instance is associated with a closure.
        // Outer scope variables must be declared final
        // effectively final (meaning unmodified after initialization) in order to be accessible
        Function<Integer, Integer> partialAdd = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer y) {
                return y + x;
            }
        };
        return partialAdd;
    }

    public static void main(String[] args) {
        ClosuresPreJava8 partialAdd = new ClosuresPreJava8();
        Function<Integer, Integer> add10 = partialAdd.add(10);
        Function<Integer, Integer> add20 = partialAdd.add(20);
        System.out.println(add10.apply(5));
        System.out.println(add20.apply(5));
    }
}
