package org.jeecqrs.example.thorntail.application.impl.queries;

import org.jeecqrs.example.thorntail.application.api.queries.OrderBean;
import org.jeecqrs.example.thorntail.application.api.queries.OrderQuery;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class OrderQueryBean implements OrderQuery {

    @EJB
    private OrderQueryDataStore ds;

    @Override
    public OrderBean getOrder(String productId) {
        return ds.get(productId);
    }
    
}
