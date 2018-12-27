package org.jeecqrs.example.openejb.application.impl.queries;

import org.jeecqrs.example.openejb.application.api.queries.OrderQuery;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jeecqrs.example.openejb.application.api.queries.OrderBean;

@Stateless
public class OrderQueryBean implements OrderQuery {

    @EJB
    private OrderQueryDataStore ds;

    @Override
    public OrderBean getOrder(String productId) {
        return ds.get(productId);
    }
    
}
