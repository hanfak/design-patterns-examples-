package archunit.onionarchitecture.domain.service;

import archunit.onionarchitecture.domain.model.Product;
import archunit.onionarchitecture.domain.model.ProductId;

public interface ProductRepository {
    Product read(ProductId id);

    long getTotalCount();
}
