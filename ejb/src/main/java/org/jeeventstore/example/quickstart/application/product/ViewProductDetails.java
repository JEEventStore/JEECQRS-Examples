package org.jeeventstore.example.quickstart.application.product;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jeeventstore.example.quickstart.domain.model.product.Product;
import org.jeeventstore.example.quickstart.domain.model.product.ProductId;
import org.jeeventstore.example.quickstart.domain.model.product.ProductRepository;

@Stateless
public class ViewProductDetails {

    @EJB
    private ProductRepository productRepository;

    public Product viewProduct(String productId) {
        ProductId pid = ProductId.fromString(productId);
        return productRepository.productOfIdentity(pid);
    }
    
}
