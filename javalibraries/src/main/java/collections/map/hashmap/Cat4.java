package collections.map.hashmap;


public class Cat4 {
    private final String name;

    public Cat4(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
