package functional.com.chapter2.methodreferences;

import java.util.Objects;
import java.util.function.Supplier;

public class SupplierExample2 {
    public static SunPower produce(Supplier<SunPower> supp) {
        return supp.get();
    }

    public static void main(String[] args) {

        SunPower p1 = produce(() -> new SunPower("bbb"));
        SunPower p2 = produce(() -> new SunPower("eee"));


        System.out.println("Check the same object? " + Objects.equals(p1, p2));
    }
}

class SunPower {

    public SunPower(String a) {
        System.out.println("Sun Power initialized.."+ a);
    }
}