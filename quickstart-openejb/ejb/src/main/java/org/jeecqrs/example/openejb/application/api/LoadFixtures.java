package org.jeecqrs.example.openejb.application.api;

import java.math.BigDecimal;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jeecqrs.common.AbstractId;
import org.jeecqrs.example.openejb.domain.model.product.Product;
import org.jeecqrs.example.openejb.domain.model.product.ProductId;
import org.jeecqrs.example.openejb.domain.model.product.ProductRepository;

@Stateless
public class LoadFixtures {

    @EJB
    private ProductRepository productRepository;

    @PostConstruct
    public void load() {
        for (int i = 100; i < 120; i++)
            productRepository.add(
                    new Product(new ProductId(i), "Product " + i,
                            "Description of product " + i, new BigDecimal(i)),
                    new AbstractId(UUID.randomUUID().toString()) {});
    }
    
}
