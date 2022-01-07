package collections.map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Example01 {

    public static void main(String... args) {
        Cat bob = new Cat("bob");
        Cat gogo = new Cat("gogo");
        Cat toto = new Cat("toto");

        Map<Cat, String> catsGreetings = Map.of(bob, "hi", gogo, "bonjour", toto, "hola");

        int size = catsGreetings.size();
        System.out.println("size = " + size);

        Cat2 bob2 = new Cat2("bob");
        Cat2 gogo2 = new Cat2("gogo");
        Cat2 toto2 = new Cat2("toto");

        // As Cat2 has same hashcode, then the number of buckets is 1, and everything is stored in a linkedlist
        Map<Cat2, String> catsGreetings2 = Map.of(bob2, "hi", gogo2, "bonjour", toto2, "hola");

        int size2 = catsGreetings2.size();
        System.out.println("size2 = " + size2);
        String s2 = catsGreetings2.get(gogo2);
        System.out.println("s2 = " + s2);

        HashMap<Cat2, String> cat2StringHashMap = new HashMap<>();
        cat2StringHashMap.put(bob2, "hi");
        cat2StringHashMap.put(gogo2, "bonjour");
        cat2StringHashMap.put(toto2, "hola");

        int size2a = cat2StringHashMap.size();
        System.out.println("size2a = " + size2a);
        String s2a = cat2StringHashMap.get(gogo2);
        System.out.println("s2a = " + s2a);
        String s2a1 = cat2StringHashMap.get(bob2);
        System.out.println("s2a1 = " + s2a1);

        Cat3 bob3 = new Cat3("bob");
        Cat3 gogo3 = new Cat3("gogo");
        Cat3 toto3 = new Cat3("toto");

        // This will add to different buckets
        Map<Cat3, String> catsGreetings3 = Map.of(bob3, "hi", gogo3, "bonjour", toto3, "hola");

        int size3 = catsGreetings3.size();
        System.out.println("size3 = " + size3);
        String s3 = catsGreetings3.get(gogo3);
        System.out.println("s3 = " + s3);


        HashMap<Cat3, String> cat3StringHashMap = new HashMap<>();
        cat3StringHashMap.put(bob3, "hi");
        cat3StringHashMap.put( gogo3, "bonjour");
        cat3StringHashMap.put(toto3, "hola");

        int size3a = cat3StringHashMap.size();
        System.out.println("size3a = " + size3a);
        String s3a = cat3StringHashMap.get(gogo3);
        System.out.println("s3a = " + s3a);

        Cat4 bob4 = new Cat4("bob");
        Cat4 gogo4 = new Cat4("gogo");
        Cat4 toto4 = new Cat4("toto");

        // Will not compile, due to Map.of creates immutable map, and thus does not allow overriding of key's value
//        Map<Cat4, String> catsGreetings4 = Map.of(bob4, "hi", gogo4, "bonjour", toto4, "hola");

        HashMap<Cat4, String> cat4StringHashMap = new HashMap<>();
        cat4StringHashMap.put(bob4, "hi");
        cat4StringHashMap.put( gogo4, "bonjour");
        cat4StringHashMap.put(toto4, "hola");

        // Will override key, everytime object is added, as it is the same hashcode
        int size4 = cat4StringHashMap.size();
        System.out.println("size4 = " + size4);
        String s4 = cat4StringHashMap.get(gogo4);
        System.out.println("s4 = " + s4);

    }
}
