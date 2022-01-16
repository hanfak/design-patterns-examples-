package archunit.onionarchitecture.adapter.persistence;

import archunit.onionarchitecture.domain.model.Product;
import archunit.onionarchitecture.domain.model.ProductId;
import archunit.onionarchitecture.domain.model.ProductName;
import archunit.onionarchitecture.domain.service.ProductRepository;

@SuppressWarnings("unused")
public class ProductJpaRepository implements ProductRepository {
    @Override
    public Product read(ProductId id) {
        return new Product(id, new ProductName("would normally be read"));
    }

    @Override
    public long getTotalCount() {
        return 0;
    }
}
