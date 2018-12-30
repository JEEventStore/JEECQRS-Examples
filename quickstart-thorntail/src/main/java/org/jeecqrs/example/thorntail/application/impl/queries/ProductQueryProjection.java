package org.jeecqrs.example.thorntail.application.impl.queries;

import org.jeecqrs.common.event.Event;
import org.jeecqrs.example.thorntail.application.api.queries.ProductBean;
import org.jeecqrs.example.thorntail.domain.model.product.ProductListed;
import org.jeecqrs.integration.jcommondomain.projections.AbstractProjection;

import javax.inject.Inject;

public class ProductQueryProjection extends AbstractProjection {

    @Inject
    private ProductQueryDataStore ds;

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
