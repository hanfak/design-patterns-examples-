package architecturepatterns.packagagestructure.archunit.onionarchitecture.domain.service;


import architecturepatterns.packagagestructure.archunit.onionarchitecture.domain.model.Product;
import architecturepatterns.packagagestructure.archunit.onionarchitecture.domain.model.ProductId;

public interface ProductRepository {
    Product read(ProductId id);

    long getTotalCount();
}
