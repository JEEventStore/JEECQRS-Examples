package org.jeecqrs.example.thorntail.application.impl.queries;

import org.jeecqrs.example.thorntail.application.api.queries.ProductBean;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A simple in-memory data store for products.
 */
@Singleton
public class ProductQueryDataStore {
    
    private final Map<String, ProductBean> entries = new HashMap<>();

    @Lock(LockType.WRITE)
    public void add(ProductBean entry) {
        entries.put(entry.getProductId(), entry);
    }

    @Lock(LockType.READ)
    public Set<ProductBean> getProducts() {
        /* return copy to protect against concurrent modification after this method returned */
        return new HashSet<>(entries.values());
    }

    @Lock(LockType.READ)
    public ProductBean get(String productId) {
        return entries.get(productId);
    }
    
}
