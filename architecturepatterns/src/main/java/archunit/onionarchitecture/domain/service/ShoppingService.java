package archunit.onionarchitecture.domain.service;

import archunit.onionarchitecture.domain.model.*;

public class ShoppingService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    public ShoppingService(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }

    public void addToShoppingCart(ShoppingCartId shoppingCartId, ProductId productId, OrderQuantity quantity) {
        ShoppingCart shoppingCart = shoppingCartRepository.read(shoppingCartId);
        Product product = productRepository.read(productId);
        OrderItem newItem = new OrderItem(product, quantity);
        shoppingCart.add(newItem);
        shoppingCartRepository.save(shoppingCart);
    }
}
