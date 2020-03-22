package javalibraries.reflection;

import java.lang.reflect.Modifier;

public class Example02 {
    private String someField;

    public Example02(String someField) {
        this.someField = someField;
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class example02 = Example02.class;

        // Access modifiers of class
        int modifiers = example02.getModifiers();
        boolean aPrivate = Modifier.isPrivate(modifiers);
        System.out.println("aPrivate = " + aPrivate);

        boolean aPublic = Modifier.isPublic(modifiers);
        System.out.println("aPublic = " + aPublic);
    }

    public String blah(int number) {
        return "Hello " + number  + someField;
    }

}
