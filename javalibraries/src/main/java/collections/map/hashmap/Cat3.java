package collections.map.hashmap;

import java.util.Objects;

public class Cat3 {
    private final String name;

    public Cat3(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
