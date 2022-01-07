package generics.example01;


import java.util.ArrayList;
import java.util.List;

/**
 * Raw Types
 * <p>
 * In the past we had to use casting
 * This was bad, as retriving contents (ie adding stuff in to list then looping to extract it out and use it)
 * of the array when we hit a different type and cast, it will
 * throw a ClassCastException!
 * This can happen at runtime, so errors may not be apparent till then ie crashing the program
 * We want to catch these error at compile time
 **/
public class Ex01RawTypes {

    public static void main(String[] args) {
        // list is raw, has no type, so can add anything to it, thus IDE is giving warning
        List list = new ArrayList();
        list.add(2);
        list.add("string");

        // The type is object, thus we can store anything in the list
        Object o = list.get(0);
        System.out.println("object = " + o);
        // Cannot use behaviour of integer with an object as it is only for integers
        //System.out.println("division with object = " + o  / 2);

        Object o1 = list.get(0);
        System.out.println("object1 = " + o1);
        // Cannot use behaviour of String with an object as it is only for integers
        // System.out.println("uppercase with object = " + o1.toUpperCase());


        //But to use the behaviour of this object we need to cast it
        Integer integer = (Integer) list.get(0);
        System.out.println("integer = " + integer);
        System.out.println("division with integer = " + integer / 2);

        String string = (String) list.get(1);
        System.out.println("string = " + string);
        System.out.println("string only behaviour = " + string.toUpperCase());

        // Can check every entry is correct before adding to the array
        List shouldBeAIntegerList = new ArrayList();
        shouldBeAIntegerList.add(checkInputShouldBeString("Hello"));
        shouldBeAIntegerList.add(checkInputShouldBeString("Goodbye"));
        // Here it will not compile
        // shouldBeAIntegerList.add(checkInputShouldBeString(2314));
    }

    private static String checkInputShouldBeString(String input) {

            if (input.getClass().equals(String.class)) {
                return input;
            } else {
                throw new IllegalArgumentException("Input should be string");
            }


    }
}
