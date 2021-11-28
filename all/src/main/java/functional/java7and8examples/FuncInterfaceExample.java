package functional.java7and8examples;

import java.util.function.Function;

public class FuncInterfaceExample {
    public static void main(String[] args) {
        System.out.println(getValue(t -> (int) (Math.random() * t), 10));
        System.out.println(getValue(x -> x * x, 20));
    }

    static Integer getValue(Function<Integer, Integer> f, int x) {
        return f.apply(x);
    }
}
