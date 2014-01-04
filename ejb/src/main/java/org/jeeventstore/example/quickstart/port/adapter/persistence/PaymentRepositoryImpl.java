package org.jeeventstore.example.quickstart.port.adapter.persistence;

import javax.ejb.Stateless;
import org.jeecqrs.bundle.quickstart.domain.AbstractRepository;
import org.jeeventstore.example.quickstart.domain.model.product.Product;
import org.jeeventstore.example.quickstart.domain.model.product.ProductId;
import org.jeeventstore.example.quickstart.domain.model.product.ProductRepository;

/**
 *
 */
@Stateless
public class ProductRepositoryImpl extends AbstractRepository<Product> implements ProductRepository {

    @Override
    public Product productOfIdentity(ProductId productId) {
        return super.ofIdentity(Product.class, productId);
    }

    @Override
    public void add(Product product, String commitId) {
        super.add(product, commitId);
    }

    @Override
    public void save(Product product, String commitId) {
        super.save(product, commitId);
    }

}
