package org.jeecqrs.example.openejb.domain.model.product;

import org.jeecqrs.common.AbstractId;

/**
 * Uniquely identifies a product.
 */
public class ProductId extends AbstractId<ProductId> {

    public ProductId(Integer productNo) {
        super(productNo.toString());
    }

    private ProductId(String productId) {
        super(productId);
    }

    public static ProductId fromString(String productId) {
        return new ProductId(productId);
    }

}
