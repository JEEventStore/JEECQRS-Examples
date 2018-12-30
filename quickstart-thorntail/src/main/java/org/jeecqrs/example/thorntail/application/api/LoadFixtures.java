package org.jeecqrs.example.thorntail.application.api;

import org.jeecqrs.common.AbstractId;
import org.jeecqrs.example.thorntail.application.api.queries.ProductQuery;
import org.jeecqrs.example.thorntail.domain.model.product.Product;
import org.jeecqrs.example.thorntail.domain.model.product.ProductId;
import org.jeecqrs.example.thorntail.domain.model.product.ProductRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.math.BigDecimal;
import java.util.UUID;

@Startup
@Singleton
public class LoadFixtures {

    @EJB
    private ProductQuery productQuery;

    @EJB
    private ProductRepository productRepository;

    @PostConstruct
    public void load() {
        if (productQuery.listProducts().size() > 0)
            return;

        System.out.println("Loading dummy products into database...");

        for (int i = 100; i < 120; i++)
            productRepository.add(
                    new Product(new ProductId(i), "Product " + i,
                            "Description of product " + i, new BigDecimal(i)),
                    new AbstractId(UUID.randomUUID().toString()) {});
    }
}
