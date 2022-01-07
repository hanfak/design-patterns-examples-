package generics.example01;


import java.util.ArrayList;
import java.util.List;

/**
 * Types
 * This gets a way of checking type first at compile time instead of waiting till runtime
 **/
public class Ex02Types {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        // We can't add string to the list of integers. Compiler catches this for us.
        // Error: no suitable method found for add(java.lang.String)
        //        method java.util.Collection.add(java.lang.Integer) is not applicable
        //        (argument mismatch; java.lang.String cannot be converted to java.lang.Integer)
        // list.add("3");
        list.add(3);
        list.add(4);

        // Casting is not needed now, as compiler knows via type set in <> what it is
        System.out.println("first element = " + list.get(0));
        // Can Cast, but IDE shows it is redundant
        System.out.println("first element = " + (Integer) list.get(0));

        // The foreach loop recognises it too
        for(Integer item : list) {
            System.out.println("item = " + item);
        }

        // Autboxing and autounboxing occurs by default
        for(int item : list) {
            System.out.println("unboxed item = " + item); // unboxing occurs automatically
        }
    }


}
