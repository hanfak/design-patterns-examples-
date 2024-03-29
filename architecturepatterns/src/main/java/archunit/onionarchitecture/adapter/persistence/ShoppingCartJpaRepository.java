package archunit.onionarchitecture.adapter.persistence;

import archunit.onionarchitecture.domain.model.ShoppingCart;
import archunit.onionarchitecture.domain.model.ShoppingCartId;
import archunit.onionarchitecture.domain.service.ShoppingCartRepository;

@SuppressWarnings("unused")
public class ShoppingCartJpaRepository implements ShoppingCartRepository {
    @Override
    public ShoppingCart read(ShoppingCartId id) {
        // would normally load fully initialized shopping cart
        return new ShoppingCart(id);
    }

    @Override
    public void save(ShoppingCart shoppingCart) {
        // store shopping cart via JPA
    }
}
