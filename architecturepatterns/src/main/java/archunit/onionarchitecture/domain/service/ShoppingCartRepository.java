package archunit.onionarchitecture.domain.service;

import archunit.onionarchitecture.domain.model.ShoppingCart;
import archunit.onionarchitecture.domain.model.ShoppingCartId;

public interface ShoppingCartRepository {
    ShoppingCart read(ShoppingCartId id);

    void save(ShoppingCart shoppingCart);
}
