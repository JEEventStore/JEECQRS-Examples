package org.jeeventstore.example.quickstart.port.adapter.persistence;

import javax.ejb.Stateless;
import org.jeeventstore.example.quickstart.domain.model.product.Product;
import org.jeeventstore.example.quickstart.domain.model.product.ProductId;
import org.jeeventstore.example.quickstart.domain.model.product.ProductRepository;

@Stateless
public class ProductRepositoryImpl extends AbstractRepository<Product, ProductId>
    implements ProductRepository {

}
