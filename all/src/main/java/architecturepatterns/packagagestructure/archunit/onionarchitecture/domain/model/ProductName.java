package architecturepatterns.packagagestructure.archunit.onionarchitecture.domain.model;

@SuppressWarnings("unused")
public class ProductName {
    private final String name;

    public ProductName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name='" + name + '\'' + '}';
    }
}
