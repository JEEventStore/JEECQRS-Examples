package org.jeecqrs.example.thorntail.port.adapter.persistence;

import org.jeecqrs.example.thorntail.domain.model.billing.Invoice;
import org.jeecqrs.example.thorntail.domain.model.billing.InvoiceId;
import org.jeecqrs.example.thorntail.domain.model.billing.InvoiceRepository;

import javax.ejb.Stateless;

@Stateless
public class InvoiceRepositoryImpl extends AbstractRepository<Invoice, InvoiceId>
    implements InvoiceRepository {

}
