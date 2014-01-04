package org.jeeventstore.example.quickstart.projections.products;

import java.io.Serializable;
import java.math.BigDecimal;
import org.jeeventstore.example.quickstart.domain.model.product.ProductId;

public class ProductListEntry implements Serializable {

    private final String productId;
    private String name;
    private String description;
    private BigDecimal price;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
