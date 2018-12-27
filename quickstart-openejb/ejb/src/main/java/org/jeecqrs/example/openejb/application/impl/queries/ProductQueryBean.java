package org.jeecqrs.example.openejb.application.impl.queries;

import java.util.Collection;
import org.jeecqrs.example.openejb.application.api.queries.ProductQuery;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jeecqrs.example.openejb.application.api.queries.ProductBean;

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
