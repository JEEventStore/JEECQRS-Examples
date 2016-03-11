package org.jeecqrs.example.openejb.application.impl.queries;

import org.jeecqrs.example.openejb.application.api.queries.ProductBean;
import javax.inject.Inject;
import org.jeecqrs.common.event.Event;
import org.jeecqrs.example.openejb.domain.model.product.ProductListed;
import org.jeecqrs.integration.jcommondomain.projections.AbstractProjection;

public class AllProductsProjection extends AbstractProjection {

    @Inject
    private AllProductsDataStore ds;

    @Override
    protected Class<? extends Event>[] listenToEvents() {
        return new Class[] {
            ProductListed.class,
        };
    }

    protected void when(ProductListed event) {
        ds.add(new ProductBean(event.productId().toString(), event.name(),
                event.description(), event.price()));
    }
    
}
