package org.jeecqrs.example.thorntail.port.adapter.persistence;

import org.jeecqrs.example.thorntail.domain.model.billing.Payment;
import org.jeecqrs.example.thorntail.domain.model.billing.PaymentId;
import org.jeecqrs.example.thorntail.domain.model.billing.PaymentRepository;

import javax.ejb.Stateless;

@Stateless
public class PaymentRepositoryImpl extends AbstractRepository<Payment, PaymentId>
    implements PaymentRepository {

}
