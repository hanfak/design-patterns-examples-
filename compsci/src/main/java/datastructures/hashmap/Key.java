package datastructures.hashmap;

import java.util.Objects;

public final class Key {

    private final String a;
    private final int b;

    public Key(String a, int b) {
        this.a = a;
        this.b = b;
    }

    public String a() {
        return a;
    }

    public int b() {
        return b;
    }

    @Override
    public String toString() {
        return "Key[" +
               "a=" + a + ", " +
               "b=" + b + ']';
    }


}
