package org.jeeventstore.example.quickstart.domain.model.product;

import org.jeecqrs.common.Identity;

/**
 *
 */
public interface ProductRepository {

    /**
     * Retrieves the product with the given identity.
     * Must exist.
     * 
     * @param productId  the id of the product to retrieve
     * @return   the product
     */
    Product productOfIdentity(ProductId productId);

    /**
     * Adds an product to the repository.
     *
     * @param product the product to add
     * @param commitId  unique id for this commit
     */
    void add(Product product, String commitId);

    /**
     * Saves an product.
     * 
     * @param product the product to save
     * @param commitId  unique id for this commit
     */
    void save(Product product, String commitId);
    
}
