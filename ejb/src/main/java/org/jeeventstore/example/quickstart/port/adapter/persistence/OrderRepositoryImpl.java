package org.jeeventstore.example.quickstart.port.adapter.persistence;

import javax.ejb.Stateless;
import org.jeecqrs.bundle.quickstart.domain.AbstractRepository;
import org.jeecqrs.common.Identity;
import org.jeecqrs.common.persistence.jeeventstore.AbstractJEEventStoreARRepository;
import org.jeeventstore.EventStore;
import org.jeeventstore.example.quickstart.domain.model.order.Order;
import org.jeeventstore.example.quickstart.domain.model.order.OrderId;
import org.jeeventstore.example.quickstart.domain.model.order.OrderRepository;

/**
 *
 */
@Stateless
public class OrderRepositoryImpl extends AbstractRepository<Order> implements OrderRepository {

    @Override
    public Order orderOfIdentity(OrderId orderId) {
        return super.ofIdentity(Order.class, orderId);
    }

    @Override
    public void add(Order order, String commitId) {
        super.add(order, commitId);
    }

    @Override
    public void save(Order order, String commitId) {
        super.add(order, commitId);
    }
    
}
