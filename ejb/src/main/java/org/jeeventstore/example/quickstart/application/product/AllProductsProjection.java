package org.jeeventstore.example.quickstart.application.product;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.Singleton;
import org.jeecqrs.common.event.Event;
import org.jeeventstore.example.quickstart.domain.model.product.ProductListed;
import org.jeecqrs.integration.jcommondomain.projections.AbstractProjection;

@Singleton
public class AllProductsProjection extends AbstractProjection {

    private final Set<ProductListEntry> entries = new HashSet<>();

    @Override
    protected Class<? extends Event>[] listenToEvents() {
        return new Class[] {
            ProductListed.class,
        };
    }

    protected void when(ProductListed event) {
        entries.add(new ProductListEntry(event.productId().toString(), event.name(),
                event.description(), event.price()));
    }

    public Set<ProductListEntry> getProducts() {
        return Collections.unmodifiableSet(entries);
    }
    
}
