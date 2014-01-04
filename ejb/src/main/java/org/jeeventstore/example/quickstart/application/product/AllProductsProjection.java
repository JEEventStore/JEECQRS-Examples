package org.jeeventstore.example.quickstart.projections.products;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import org.jeecqrs.common.event.Event;
import org.jeeventstore.example.quickstart.domain.model.product.ProductListed;
import org.jeeventstore.example.quickstart.domain.model.product.ProductPriceChanged;
import org.jeeventstore.example.quickstart.domain.model.product.ProductRepository;
import org.jeecqrs.bundle.quickstart.projections.AbstractProjection;

@Singleton
public class AllProductsProjection extends AbstractProjection {

    @EJB
    private ProductRepository productRepository;

    private final Set<ProductListEntry> entries = new HashSet<ProductListEntry>();

    @Override
    protected Class<? extends Event>[] listenToEvents() {
        return new Class[] {
            ProductListed.class,
            ProductPriceChanged.class
        };
    }

    protected void when(ProductListed event) {
        System.out.println("#### received product listed: " + event.productId().idString());
        entries.add(new ProductListEntry(event.productId().idString(), event.name(),
                event.description(), event.price()));
    }

    protected void when(ProductPriceChanged event) {
        System.out.println("#### price changed: " + event.productId().idString() + " --> " + event.newPrice());
        for (ProductListEntry e : entries) {
            if (e.getProductId().equals(event.productId().idString())) {
                e.setPrice(event.newPrice());
                return;
            }
        }
    }

    public Set<ProductListEntry> getProducts() {
        return Collections.unmodifiableSet(entries);
    }
    
}
