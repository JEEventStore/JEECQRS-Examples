package org.jeecqrs.example.quickstart.application.product;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductListEntry implements Serializable {

    private final String productId;
    private final String name;
    private final String description;
    private final BigDecimal price;

    public ProductListEntry(String productId, String name, String description, BigDecimal price) {
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
