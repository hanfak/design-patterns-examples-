package javalibraries.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Example03 {
    private String someField;
    public Boolean otherField;

    public Example03(String someField, Boolean otherField) {
        this.someField = someField;
        this.otherField = otherField;
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class example03 = Example03.class;

        // Constructors
        Constructor[] constructors = example03.getConstructors();
        System.out.println("constructors = " + Arrays.toString(constructors));

//        Class[] classes = {Example03.class};
//        Constructor constructor1 = example03.getConstructor(classes);
//        System.out.println(constructor1);
//        System.out.println("constructor = " + constructor);

        Constructor constructor = constructors[0];
        Class[] parameterTypes = constructor.getParameterTypes();
        System.out.println("parameterTypes = " + parameterTypes[0]);
        System.out.println("parameterTypes = " + parameterTypes[1]);

        // Instantiate the object
        Example03 boom = (Example03) constructor.newInstance("boom", false);
        String blah = boom.blah(4);
        System.out.println("blah = " + blah);

    }

    public String blah(int number) {
        return "Hello " + number  + someField;
    }

}
