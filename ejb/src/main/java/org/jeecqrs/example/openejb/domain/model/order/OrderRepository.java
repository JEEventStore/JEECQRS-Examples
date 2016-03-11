package org.jeecqrs.example.openejb.domain.model.order;

import org.jeecqrs.common.Identity;
import org.jeecqrs.common.domain.model.Repository;

public interface OrderRepository extends Repository<Order, OrderId, Identity> {

}
