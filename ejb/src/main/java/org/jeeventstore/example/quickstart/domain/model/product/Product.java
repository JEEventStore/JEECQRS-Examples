package org.jeeventstore.example.quickstart.domain.model.product;

import java.math.BigDecimal;
import org.apache.commons.lang3.Validate;
import org.jeecqrs.common.domain.model.AbstractEventSourcedAggregateRoot;

public class Product extends AbstractEventSourcedAggregateRoot<Product, ProductId> {

    private ProductId productId;
    private String name;
    private String description;
    private BigDecimal price;

    public Product(ProductId productId, String name, String description, BigDecimal price) {
        Validate.notNull(productId, "productId must not be null");
        Validate.notEmpty(name, "product name must not be empty");
        Validate.notEmpty(description, "description must not be empty");
        Validate.notNull(price, "price must not be null");
        this.apply(new ProductListed(productId, name, description, price));
    }

    @Override
    public ProductId id() {
        return this.productId;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public BigDecimal price() {
        return price;
    }

    protected void when(ProductListed event) {
        this.productId = event.productId();
        this.name = event.name();
        this.description = event.description();
        this.price = event.price();
    }

    // required for repository
    private Product() { }

}
