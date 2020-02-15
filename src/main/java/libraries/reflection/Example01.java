package libraries.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Example01 {
    private String someField;

    public Example01(String someField) {
        this.someField = someField;
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Example01 boom = new Example01("boom");
        String blah = boom.blah(4);
        System.out.println("blah = " + blah);

        Method[] methods = Example01.class.getMethods();

        for(Method method : methods){
            System.out.println("method = " + method.getName());
        }
        // Need the class to be able to use the reflection library
        Class example01 = Example01.class;
        System.out.println(example01.getName());
        System.out.println(example01.getSimpleName());
        System.out.println(example01.getPackage());

        // If do not know then use
        Class example01RetrieveName = Class.forName("com.hanfak.reflection.Example01");
        System.out.println(Arrays.toString(example01RetrieveName.getDeclaredFields()));
    }

    public String blah(int number) {
        return "Hello " + number  + someField;
    }

}
