package passbyvalue;

import org.openjdk.jol.vm.VM;

//++a increments and then uses the variable.
//a++ uses and then increments the variable.
public class Test{
    private static final String OBJECT_INTEGER_NAME_BEFORE = "object integer name before ";
    private static final String OBJECT_INTEGER_NAME_AFTER = "object integer name after ";
    private static final String PRIMITIVE_INTEGER_NAME_BEFORE = "primitive integer name before ";
    private static final String PRIMITIVE_INTEGER_NAME_AFTER = "primitive integer name after ";

    public static void testInts(Integer objectInteger, int primitiveInteger){
        System.out.println("\n In method");
        System.out.println("object integer name before in method start " + objectInteger);
        System.out.println("object integer address before in method start " + VM.current().addressOf(objectInteger));
        System.out.println("primitive integer name before in method start " + primitiveInteger);
        System.out.println("primitive integer address before in method start " + VM.current().addressOf(primitiveInteger));
        objectInteger = primitiveInteger++;
        System.out.println("object integer address after reassignment before in method start " + VM.current().addressOf(objectInteger));
        System.out.println("object integer name before in method after assignment " + objectInteger);
        System.out.println("primitive integer name before in method after assignment " + primitiveInteger);

        Integer integer = objectInteger++;
        System.out.println(" integer address after inrement" + VM.current().addressOf(integer));
        System.out.println("object integer name before in method after increment " + objectInteger);
        System.out.println("primitive integer name before in method after increment " + primitiveInteger);
        System.out.println(" method finished\n");
    }



//    public static void testInts(Integer obj, int var){
    // creates copy of the obj ref (points to actual object on heap mem)
    // creates copy of primitive value
//        obj = var++; //assigns the obj variable with int value from the copy of var
//        obj++; //this is now incremementing the int and not the Integer
    // When method is done the copies are cleaned up by garbage collector
//    }

//    public static void main(String[] args) {


//        Integer val1 = new Integer(5); // new object is in heap memory, and val1 stores the pointer/reference to the object on heap memory
//        int val2 = 9; // int is primitve, it stores the actual value in the location of val2
    //val1++ uses and then increments the variable.  (thats why the method has value of 5 for first arg)
    //++val2 increments and then uses the variable. (thats why the method has value of 10 for second arg)
//        testInts(val1++, ++val2);
            // val1++ is autoboxing the Integer to int, then incrementing and returning a new Integer (a new reference is stored in val1)
            // ++val2 changes the value directly and reassigns to same value (which has the same address
//        System.out.println(val1+" "+val2);
//    }

    public static void main(String[] args) {
//        case1();
//        case2();
//        case3();
        case4();
//        case5();
//        case6();


//        Integer val1 = new Integer(5);
//        int val2 = 9;
//        testInts(val1++, ++val2);
//        System.out.println(val1+" "+val2);
    }

    private static void case1() {
        System.out.println("\nCase 1 - ");
        Integer val1 = new Integer(5);
        System.out.println("Object integer address " + VM.current().addressOf(val1));
        int val2 = 9;
        System.out.println("Primitive integer address " + VM.current().addressOf(val2));
        System.out.println(OBJECT_INTEGER_NAME_BEFORE + val1);
        System.out.println(PRIMITIVE_INTEGER_NAME_BEFORE + val2);
        testInts(val1, val2);
        System.out.println(OBJECT_INTEGER_NAME_AFTER + val1);
        System.out.println(PRIMITIVE_INTEGER_NAME_AFTER + val2);
    }

    private static void case2() {
        System.out.println("\nCase 2 - ");
        Integer val1 = new Integer(5);
        System.out.println("Object integer address " + VM.current().addressOf(val1));
        int val2 = 9;
        System.out.println("Primitive integer address " + VM.current().addressOf(val2));
        System.out.println(OBJECT_INTEGER_NAME_BEFORE + val1);
        System.out.println(PRIMITIVE_INTEGER_NAME_BEFORE + val2);
        testInts(val1++, val2);
        System.out.println(OBJECT_INTEGER_NAME_AFTER + val1);
        System.out.println(PRIMITIVE_INTEGER_NAME_AFTER + val2);
    }

    private static void case3() {
        System.out.println("\nCase 3 - ");
        Integer val1 = new Integer(5);
        System.out.println("Object integer address " + VM.current().addressOf(val1));
        int val2 = 9;
        System.out.println("Primitive integer address " + VM.current().addressOf(val2));
        System.out.println(OBJECT_INTEGER_NAME_BEFORE + val1);
        System.out.println(PRIMITIVE_INTEGER_NAME_BEFORE + val2);
        testInts(++val1, val2);
        System.out.println(OBJECT_INTEGER_NAME_AFTER + val1);
        System.out.println(PRIMITIVE_INTEGER_NAME_AFTER + val2);
    }

    private static void case4() {
        System.out.println("\nCase 4 - ");
        Integer val1 = new Integer(5);
        System.out.println("Object integer address " + VM.current().addressOf(val1));
        System.out.println("Object integer hash " + val1.hashCode());
        int val2 = 9;
        System.out.println("Primitive integer address " + VM.current().addressOf(val2));
        System.out.println(OBJECT_INTEGER_NAME_BEFORE + val1);
        System.out.println(PRIMITIVE_INTEGER_NAME_BEFORE + val2);
        testInts(val1++, ++val2);
        System.out.println(OBJECT_INTEGER_NAME_AFTER + val1);
        System.out.println("   Object integer address after incr" + VM.current().addressOf(val1));
        System.out.println("   Object integer hash after incr" + val1.hashCode());
        System.out.println(PRIMITIVE_INTEGER_NAME_AFTER + val2);
        System.out.println("   Primitive integer address after incr" + VM.current().addressOf(val2));

    }

    private static void case5() {
        System.out.println("\nCase 5 - ");
        Integer val1 = new Integer(5);
        System.out.println("Object integer address " + VM.current().addressOf(val1));
        int val2 = 9;
        System.out.println("Primitive integer address " + VM.current().addressOf(val2));
        System.out.println(OBJECT_INTEGER_NAME_BEFORE + val1);
        System.out.println(PRIMITIVE_INTEGER_NAME_BEFORE + val2);
        testInts(val1, val2++);
        System.out.println(OBJECT_INTEGER_NAME_AFTER + val1);
        System.out.println(PRIMITIVE_INTEGER_NAME_AFTER + val2);
    }


    private static void case6() {
        System.out.println("\nCase 6 - ");
        Integer val1 = new Integer(5);
        System.out.println("Object integer address " + VM.current().addressOf(val1));
        int val2 = 9;
        System.out.println("Primitive integer address " + VM.current().addressOf(val2));
        System.out.println(OBJECT_INTEGER_NAME_BEFORE + val1);
        System.out.println(PRIMITIVE_INTEGER_NAME_BEFORE + val2);
        testInts(val1++, ++val2);
//        val1++;
        System.out.println(OBJECT_INTEGER_NAME_AFTER + val1);
        System.out.println(PRIMITIVE_INTEGER_NAME_AFTER + val2);
    }
}


