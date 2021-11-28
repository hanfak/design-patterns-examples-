package javalibraries.sorting.arrayslistgenerics;

public class ExamplesGenerics {

    public static void main(String[] args) {

        // Exception at runtime
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in";

        //Exception at compile time
//        List<Object> ol = new ArrayList<Long>(); // Incompatible types
//        ol.add("I don't fit in");


    }

}
