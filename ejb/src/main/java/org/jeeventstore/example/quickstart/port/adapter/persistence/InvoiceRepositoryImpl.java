package org.jeeventstore.example.quickstart.port.adapter.persistence;

import javax.ejb.Stateless;
import org.jeeventstore.example.quickstart.domain.model.billing.Invoice;
import org.jeeventstore.example.quickstart.domain.model.billing.InvoiceId;
import org.jeeventstore.example.quickstart.domain.model.billing.InvoiceRepository;

@Stateless
public class InvoiceRepositoryImpl extends AbstractRepository<Invoice, InvoiceId>
    implements InvoiceRepository {

}
