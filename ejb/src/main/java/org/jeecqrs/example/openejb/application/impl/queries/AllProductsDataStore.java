package org.jeecqrs.example.openejb.application.impl.queries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import org.jeecqrs.example.openejb.application.api.queries.ProductBean;

/**
 * A simple in-memory data store for products.
 */
@Singleton
public class AllProductsDataStore {
    
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
