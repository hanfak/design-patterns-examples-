package functional.com.chapter2.methodreferences;


import functional.com.chapter1.functionalinterfaces.betterstring.ElementUtils;

/**
 * Created by hanfak on 25/06/2017.
 */
public class BetterString {

    public static void main(String[] args) {
        String message ="Better of %s and %s based on %s is %s.%n";

        Car car1 = new Car(15.99, "car1");
        Car car2 = new Car(17.01, "car2");
        Car betterCar = ElementUtils.betterElement(car1, car2, CarPredicates::getCarElementPredicate);
        System.out.println("using generics and objects, method references");
        System.out.printf(message, car1.name, car2.name, "price", betterCar.name);
    }
}

class CarPredicates {
    public static boolean getCarElementPredicate(Car carA, Car carB) {
        return carA.price > carB.price;
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

