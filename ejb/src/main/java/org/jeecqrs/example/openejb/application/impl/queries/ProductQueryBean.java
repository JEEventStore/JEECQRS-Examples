package org.jeecqrs.example.openejb.application.impl.queries;

import java.util.Collection;
import org.jeecqrs.example.openejb.application.api.queries.ProductQuery;
import org.jeecqrs.example.openejb.application.api.queries.ProductBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jeecqrs.example.openejb.application.api.queries.ProductBean;
import org.jeecqrs.example.openejb.domain.model.product.Product;
import org.jeecqrs.example.openejb.domain.model.product.ProductId;
import org.jeecqrs.example.openejb.domain.model.product.ProductRepository;

@Stateless
public class ProductQueryBean implements ProductQuery {

    @EJB
    private AllProductsDataStore ds;

    @Override
    public Collection<ProductBean> listProducts() {
        return ds.getProducts();
    }

    @Override
    public ProductBean getProduct(String productId) {
        return ds.get(productId);
    }
    
}
