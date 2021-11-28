package architecturepatterns.packagagestructure.archunit.onionarchitecture.domain.service;


import architecturepatterns.packagagestructure.archunit.onionarchitecture.domain.model.ShoppingCart;
import architecturepatterns.packagagestructure.archunit.onionarchitecture.domain.model.ShoppingCartId;

public interface ShoppingCartRepository {
    ShoppingCart read(ShoppingCartId id);

    void save(ShoppingCart shoppingCart);
}
