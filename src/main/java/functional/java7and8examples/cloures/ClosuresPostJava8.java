package functional.java7and8examples.cloures;

import java.util.function.Function;

public class ClosuresPostJava8 {
    Function<Integer, Integer> add(final int x) {
        return y -> y + x;
    }

    public static void main(String[] args) {
        ClosuresPostJava8 partialAdd = new ClosuresPostJava8();
        Function<Integer, Integer> add10 = partialAdd.add(10);
        Function<Integer, Integer> add20 = partialAdd.add(20);
        System.out.println(add10.apply(5));
        System.out.println(add20.apply(5));
    }
}
