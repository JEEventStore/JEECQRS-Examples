package org.jeeventstore.example.quickstart.domain.model.order;

import java.math.BigDecimal;
import org.jeecqrs.common.domain.model.AbstractDomainEvent;
import org.jeeventstore.example.quickstart.domain.model.product.ProductId;

/**
 *
 */
public class OrderLineAdded extends AbstractDomainEvent<OrderLineAdded> {
    
    private final OrderLineId lineId;
    private final ProductId productId;
    private final String productName;
    private final BigDecimal pricePerItem;
    private final Integer quantity;

    public OrderLineAdded(OrderLineId lineId, ProductId productId,
            String productName, BigDecimal pricePerItem, Integer quantity) {
        this.lineId = lineId;
        this.productId = productId;
        this.productName = productName;
        this.pricePerItem = pricePerItem;
        this.quantity = quantity;
    }

    public OrderLineId lineId() {
        return lineId;
    }

    public ProductId productId() {
        return productId;
    }

    public String productName() {
        return productName;
    }

    public BigDecimal pricePerItem() {
        return pricePerItem;
    }

    public Integer quantity() {
        return quantity;
    }
    
}
