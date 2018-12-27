package org.jeecqrs.example.openejb.port.adapter.persistence;

import javax.ejb.Stateless;
import org.jeecqrs.example.openejb.domain.model.billing.Payment;
import org.jeecqrs.example.openejb.domain.model.billing.PaymentId;
import org.jeecqrs.example.openejb.domain.model.billing.PaymentRepository;

@Stateless
public class PaymentRepositoryImpl extends AbstractRepository<Payment, PaymentId>
    implements PaymentRepository {

}
