package org.jeecqrs.example.quickstart.application.product;

import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProductList {

    @Inject
    private AllProductsDataStore ds;

    public Collection<ProductListEntry> allProducts() {
        return ds.getProducts();
    }
    
}
