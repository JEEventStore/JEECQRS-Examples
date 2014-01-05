package org.jeeventstore.example.quickstart.port.adapter.persistence;

import javax.ejb.Stateless;
import org.jeeventstore.example.quickstart.domain.model.order.Order;
import org.jeeventstore.example.quickstart.domain.model.order.OrderId;
import org.jeeventstore.example.quickstart.domain.model.order.OrderRepository;

@Stateless
public class OrderRepositoryImpl extends AbstractRepository<Order, OrderId> implements OrderRepository {

}
