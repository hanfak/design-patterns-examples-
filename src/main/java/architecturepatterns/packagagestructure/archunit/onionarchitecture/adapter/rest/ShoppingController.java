package architecturepatterns.packagagestructure.archunit.onionarchitecture.adapter.rest;


import architecturepatterns.packagagestructure.archunit.onionarchitecture.domain.model.OrderQuantity;
import architecturepatterns.packagagestructure.archunit.onionarchitecture.domain.model.ProductId;
import architecturepatterns.packagagestructure.archunit.onionarchitecture.domain.model.ShoppingCartId;
import architecturepatterns.packagagestructure.archunit.onionarchitecture.domain.service.ShoppingService;

import java.util.UUID;

@SuppressWarnings("unused")
public class ShoppingController {
    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    // @POST or similar
    public void addToShoppingCart(UUID shoppingCartId, UUID productId, int quantity) {
        shoppingService.addToShoppingCart(new ShoppingCartId(shoppingCartId), new ProductId(productId), new OrderQuantity(quantity));
    }
}
