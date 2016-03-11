package org.jeecqrs.example.openejb.domain.model.billing;

import org.jeecqrs.common.AbstractId;
import org.jeecqrs.example.openejb.domain.model.order.OrderId;

/**
 * Uniquely identifies an invoice.
 */
public final class InvoiceId extends AbstractId<InvoiceId> {

    private InvoiceId(String idString) {
        super(idString);
    }

    public static InvoiceId fromString(String idString) {
        return new InvoiceId(idString);
    }

}
