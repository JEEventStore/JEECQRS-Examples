package org.jeecqrs.example.thorntail.port.adapter.persistence;

import org.jeecqrs.example.thorntail.domain.model.product.Product;
import org.jeecqrs.example.thorntail.domain.model.product.ProductId;
import org.jeecqrs.example.thorntail.domain.model.product.ProductRepository;

import javax.ejb.Stateless;

@Stateless
public class ProductRepositoryImpl extends AbstractRepository<Product, ProductId>
    implements ProductRepository {

}
