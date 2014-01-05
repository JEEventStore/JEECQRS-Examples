package org.jeecqrs.example.quickstart.port.adapter.persistence;

import javax.ejb.EJB;
import org.jeecqrs.common.Identity;
import org.jeecqrs.common.domain.model.AbstractEventSourcedAggregateRoot;
import org.jeecqrs.common.persistence.jeeventstore.AbstractJEEventStoreARRepository;
import org.jeeventstore.EventStore;

/**
 *
 * @param <T>  the AR type
 * @param <ID>  the type used to identify the ARs
 */
public abstract class AbstractRepository<T extends AbstractEventSourcedAggregateRoot<T, ID>, ID extends Identity>
        extends AbstractJEEventStoreARRepository<T, ID> {

    @EJB
    private EventStore eventStore;

    @Override
    protected String bucketId() {
        return Resources.DOMAIN_BUCKET_ID;
    }

    @Override
    protected EventStore eventStore() {
        return eventStore;
    }

}