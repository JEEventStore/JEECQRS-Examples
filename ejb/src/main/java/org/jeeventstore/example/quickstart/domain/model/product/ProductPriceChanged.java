package org.jeeventstore.example.quickstart.domain.model.product;

import java.math.BigDecimal;
import org.jeecqrs.common.domain.model.AbstractDomainEvent;

/**
 * The price of a product has changed.
 */
public final class ProductPriceChanged extends AbstractDomainEvent<ProductPriceChanged> {

    private final ProductId productId;
    private final BigDecimal newPrice;

    public ProductPriceChanged(ProductId productId, BigDecimal newPrice) {
        this.productId = productId;
        this.newPrice = newPrice;
    }

    public ProductId productId() {
        return productId;
    }

    public BigDecimal newPrice() {
        return newPrice;
    }
    
}
