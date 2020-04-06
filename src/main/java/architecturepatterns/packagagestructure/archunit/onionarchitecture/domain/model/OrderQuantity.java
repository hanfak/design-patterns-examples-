package architecturepatterns.packagagestructure.archunit.onionarchitecture.domain.model;

@SuppressWarnings("unused")
public class OrderQuantity {
    private final int quantity;

    public OrderQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{quantity=" + quantity + '}';
    }
}
