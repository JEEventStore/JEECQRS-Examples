package org.jeecqrs.example.thorntail.application.api.queries;

import java.util.Collection;

public interface ProductQuery {
    
    Collection<ProductBean> listProducts();
    ProductBean getProduct(String productId);
    
}
