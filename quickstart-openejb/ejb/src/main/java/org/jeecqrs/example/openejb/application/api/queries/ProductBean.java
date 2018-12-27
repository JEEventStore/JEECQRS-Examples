package org.jeecqrs.example.openejb.application.api.queries;

import java.io.Serializable;
import java.math.BigDecimal;

public final class ProductBean implements Serializable {

    private final String productId;
    private final String name;
    private final String description;
    private final BigDecimal price;

    public ProductBean(String productId, String name, String description, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
