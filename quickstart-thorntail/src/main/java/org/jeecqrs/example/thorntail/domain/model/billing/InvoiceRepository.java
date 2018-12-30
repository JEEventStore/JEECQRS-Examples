package org.jeecqrs.example.thorntail.domain.model.billing;

import org.jeecqrs.common.Identity;
import org.jeecqrs.common.domain.model.Repository;

public interface InvoiceRepository extends Repository<Invoice, InvoiceId, Identity> {

}
