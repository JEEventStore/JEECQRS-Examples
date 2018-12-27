package org.jeecqrs.example.quickstart.application.product;

import java.util.HashSet;
import java.util.Set;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 * A simple in-memory data store for products.
 */
@Singleton
public class AllProductsDataStore {
    
    private final Set<ProductListEntry> entries = new HashSet<>();

    @Lock(LockType.WRITE)
    public void add(ProductListEntry entry) {
        entries.add(entry);
    }

    @Lock(LockType.READ)
    public Set<ProductListEntry> getProducts() {
        /* return copy to protect against concurrent modification after this method returned */
        return new HashSet<>(entries);
    }
    
}
