package functional.com.chapter2.methodreferences;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> i = ()-> "Han";

        System.out.println(i.get());


    }

}
