package architecturepatterns.packagagestructure.archunit.onionarchitecture.domain.model;

public class Product {
    private final ProductId id;
    private final ProductName name;

    public Product(ProductId id, ProductName name) {
        if (id == null) {
            throw new IllegalArgumentException("Product id must not be null");
        }
        if (name == null) {
            throw new IllegalArgumentException("Product name must not be null");
        }
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id=" + id + ", name=" + name + '}';
    }
}
