package org.jeecqrs.example.thorntail.port.adapter.persistence;

import org.jeecqrs.example.thorntail.domain.model.order.Order;
import org.jeecqrs.example.thorntail.domain.model.order.OrderId;
import org.jeecqrs.example.thorntail.domain.model.order.OrderRepository;

import javax.ejb.Stateless;

@Stateless
public class OrderRepositoryImpl extends AbstractRepository<Order, OrderId> implements OrderRepository {

}
