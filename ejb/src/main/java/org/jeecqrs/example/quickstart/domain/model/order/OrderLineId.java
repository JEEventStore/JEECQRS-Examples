package org.jeecqrs.example.quickstart.domain.model.order;

import org.jeecqrs.common.AbstractId;
import org.jeecqrs.example.quickstart.domain.model.product.Product;

/**
 * Uniquely defines an order line within an order.
 */
public final class OrderLineId extends AbstractId<OrderLineId> {

    private OrderLineId(String productId) {
        super(productId);
    }

    protected static OrderLineId forProduct(Product product) {
        return new OrderLineId(product.id().toString());
    }

}
