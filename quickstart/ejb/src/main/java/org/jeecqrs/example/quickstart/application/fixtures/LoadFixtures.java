package org.jeecqrs.example.quickstart.application.fixtures;

import java.math.BigDecimal;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jeecqrs.common.AbstractId;
import org.jeecqrs.example.quickstart.domain.model.product.Product;
import org.jeecqrs.example.quickstart.domain.model.product.ProductId;
import org.jeecqrs.example.quickstart.domain.model.product.ProductRepository;

@Stateless
public class LoadFixtures {

    @EJB
    private ProductRepository productRepository;

    public void load() {

        for (int i = 100; i < 120; i++)
            productRepository.add(
                    new Product(new ProductId(i), "Product " + i,
                            "Description of product " + i, new BigDecimal(i)),
                    new AbstractId(UUID.randomUUID().toString()) {});
    }
    
}
