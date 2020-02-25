package functional.com.chapter1.functionalinterfaces.betterstring;

/**
 * Created by hanfak on 25/06/2017.
 */
public class BetterString {

    public static void main(String[] args) {
        String test1 = "Hello";
        String test2 = "Goodbye";
        String message ="Better of %s and %s based on %s is %s.%n";
        String result1 = StringUtils.betterString(test1, test2, (s1, s2) -> s2.length() > s1.length());
        System.out.printf(message, test1, test2, "length", result1);

        String result2 = StringUtils.betterString(test1, test2, (s1, s2) -> true);
        System.out.println("Return first argument");
        System.out.printf(message, test1, test2, "1st arg", result2);

        int result3 =
                ElementUtils.betterElement(3, 2, (n1, n2) -> n1 > n2);
        System.out.println("using generics");
        System.out.printf(message, 3, 2, "numeric size", result3);


        Car car1 = new Car(15.99, "car1");
        Car car2 = new Car(17.01, "car2");
        Car betterCar = ElementUtils.betterElement(car1, car2, (carA, carB) -> carA.price > carB.price);
        Car betterCarAlt = ElementUtils.betterElement(car1, car2, getCarElementPredicate());

        System.out.println("using generics and objects");
        System.out.printf(message, car1.name, car2.name, "price", betterCar.name);
        System.out.println("using generics and objects, alt");
        System.out.printf(message, car1.name, car2.name, "price", betterCarAlt.name);
    }

    private static TwoElementPredicate<Car> getCarElementPredicate() {
        return (carA, carB) -> carA.price > carB.price;
    }
}

class Car {
    public final double price;
    public final String name;

    Car(double price, String name) {
        this.price = price;
        this.name = name;
    }
}

