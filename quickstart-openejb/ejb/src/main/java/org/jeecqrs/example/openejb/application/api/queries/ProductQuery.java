package org.jeecqrs.example.openejb.application.api.queries;

import java.util.Collection;

public interface ProductQuery {
    
    Collection<ProductBean> listProducts();
    ProductBean getProduct(String productId);
    
}
