package architecturepatterns.packagagestructure.archunit.onionarchitecture.domain.model;

public class OrderItem {
    private final Product product;
    private final OrderQuantity quantity;

    public OrderItem(Product product, OrderQuantity quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
        if (quantity == null) {
            throw new IllegalArgumentException("Quantity not be null");
        }
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{product=" + product + ", quantity=" + quantity + '}';
    }
}
