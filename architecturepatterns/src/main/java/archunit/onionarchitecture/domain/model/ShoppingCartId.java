package archunit.onionarchitecture.domain.model;

import java.util.UUID;

public class ShoppingCartId {
    private final UUID id;

    public ShoppingCartId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id=" + id + '}';
    }
}
