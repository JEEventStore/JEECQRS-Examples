package org.jeeventstore.example.quickstart.sagas.orders;

import org.jeecqrs.bundle.jcommondomain.sagas.AbstractSaga;
import org.jeecqrs.bundle.jcommondomain.sagas.AbstractSagaConfigProvider;
import org.jeecqrs.bundle.jcommondomain.sagas.AbstractSagaIdentificationStrategy;
import org.jeecqrs.common.event.Event;
import org.jeecqrs.sagas.SagaConfig;
import org.jeecqrs.sagas.SagaIdentificationStrategy;
import org.jeeventstore.example.quickstart.domain.model.order.OrderCanceled;
import org.jeeventstore.example.quickstart.domain.model.order.OrderPlaced;

/**
 *
 */
public class OrderTrackingSagaProvider extends AbstractSagaConfigProvider {

    @Override
    public Class<? extends AbstractSaga> sagaClass() {
        return OrderTrackingSaga.class;
    }

    @Override
    protected SagaIdentificationStrategy<Event> identificationStrategy() {
        return new OrderSagaIdentifier();
    }

    @Override
    protected Class<? extends Event>[] listenToEvents() {
        return new Class[] {
            OrderPlaced.class,
            OrderCanceled.class
        };
    }

    private static class OrderSagaIdentifier extends AbstractSagaIdentificationStrategy {
        protected String when(OrderPlaced event) {
            return event.orderId().idString();
        }
    }

}
