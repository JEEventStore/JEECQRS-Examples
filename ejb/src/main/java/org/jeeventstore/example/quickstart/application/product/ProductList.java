package org.jeeventstore.example.quickstart.application.product;

import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ProductList {

    @EJB
    private AllProductsProjection allProductsProjection;

    public Collection<ProductListEntry> allProducts() {
        return allProductsProjection.getProducts();
    }
    
}
