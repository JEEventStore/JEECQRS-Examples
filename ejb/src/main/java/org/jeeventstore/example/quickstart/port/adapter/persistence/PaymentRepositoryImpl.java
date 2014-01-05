package org.jeeventstore.example.quickstart.port.adapter.persistence;

import javax.ejb.Stateless;
import org.jeeventstore.example.quickstart.domain.model.billing.Payment;
import org.jeeventstore.example.quickstart.domain.model.billing.PaymentId;
import org.jeeventstore.example.quickstart.domain.model.billing.PaymentRepository;

@Stateless
public class PaymentRepositoryImpl extends AbstractRepository<Payment, PaymentId>
    implements PaymentRepository {

}
