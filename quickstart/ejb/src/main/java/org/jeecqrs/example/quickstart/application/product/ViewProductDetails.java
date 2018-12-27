package org.jeecqrs.example.quickstart.application.product;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jeecqrs.example.quickstart.domain.model.product.Product;
import org.jeecqrs.example.quickstart.domain.model.product.ProductId;
import org.jeecqrs.example.quickstart.domain.model.product.ProductRepository;

@Stateless
public class ViewProductDetails {

    @EJB
    private ProductRepository productRepository;

    public ProductDetails viewProduct(String productId) {
        ProductId pid = ProductId.fromString(productId);
        Product p = productRepository.ofIdentity(pid);
        ProductDetails details = new ProductDetails(productId, p.name(), p.description(), p.price());
        return details;
    }
    
}
