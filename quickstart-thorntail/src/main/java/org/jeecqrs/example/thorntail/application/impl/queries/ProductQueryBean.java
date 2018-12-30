package org.jeecqrs.example.thorntail.application.impl.queries;

import org.jeecqrs.example.thorntail.application.api.queries.ProductBean;
import org.jeecqrs.example.thorntail.application.api.queries.ProductQuery;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Collection;

@Stateless
public class ProductQueryBean implements ProductQuery {

    @EJB
    private ProductQueryDataStore ds;

    @Override
    public Collection<ProductBean> listProducts() {
        return ds.getProducts();
    }

    @Override
    public ProductBean getProduct(String productId) {
        return ds.get(productId);
    }
    
}
