package org.jeecqrs.example.openejb.port.adapter.persistence;

import javax.ejb.Stateless;
import org.jeecqrs.example.openejb.domain.model.product.Product;
import org.jeecqrs.example.openejb.domain.model.product.ProductId;
import org.jeecqrs.example.openejb.domain.model.product.ProductRepository;

@Stateless
public class ProductRepositoryImpl extends AbstractRepository<Product, ProductId>
    implements ProductRepository {

}
