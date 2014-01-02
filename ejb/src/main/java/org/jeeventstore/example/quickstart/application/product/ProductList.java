package org.jeeventstore.example.quickstart.application.product;

import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jeeventstore.example.quickstart.projections.products.AllProductsProjection;
import org.jeeventstore.example.quickstart.projections.products.ProductListEntry;

@Stateless
public class ProductList {

    @EJB
    private AllProductsProjection allProductsProjection;

    public Collection<ProductListEntry> allProducts() {
        return allProductsProjection.getProducts();
    }
    
}
