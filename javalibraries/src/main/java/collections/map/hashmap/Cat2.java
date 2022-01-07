package collections.map.hashmap;

public class Cat2 {
    private final String name;

    public Cat2(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cat2 cat = (Cat2) o;
        return name.equals(cat.name);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
