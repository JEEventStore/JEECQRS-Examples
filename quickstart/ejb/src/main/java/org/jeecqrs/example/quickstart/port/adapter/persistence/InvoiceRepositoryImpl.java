package org.jeecqrs.example.quickstart.port.adapter.persistence;

import javax.ejb.Stateless;
import org.jeecqrs.example.quickstart.domain.model.billing.Invoice;
import org.jeecqrs.example.quickstart.domain.model.billing.InvoiceId;
import org.jeecqrs.example.quickstart.domain.model.billing.InvoiceRepository;

@Stateless
public class InvoiceRepositoryImpl extends AbstractRepository<Invoice, InvoiceId>
    implements InvoiceRepository {

}
