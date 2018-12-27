package org.jeecqrs.example.quickstart.port.adapter.persistence;

import javax.ejb.EJB;
import org.jeecqrs.common.Identity;
import org.jeecqrs.common.domain.model.AbstractEventSourcedAggregateRoot;
import org.jeecqrs.common.persistence.es.CanonicalNameEventStreamNameGenerator;
import org.jeecqrs.common.persistence.es.EventStreamNameGenerator;
import org.jeecqrs.common.persistence.jeeventstore.AbstractJEEventStoreARRepository;
import org.jeeventstore.EventStore;

/**
 *
 * @param <T>  the AR type
 * @param <ID>  the type used to identify the ARs
 */
public abstract class AbstractRepository<T extends AbstractEventSourcedAggregateRoot<T, ID>, ID extends Identity>
        extends AbstractJEEventStoreARRepository<T, ID, Identity> {

    @EJB
    private EventStore eventStore;

    private EventStreamNameGenerator<T, ID> esng = new CanonicalNameEventStreamNameGenerator<>();

    @Override
    protected String bucketId() {
        return Resources.DOMAIN_BUCKET_ID;
    }

    @Override
    protected EventStore eventStore() {
        return eventStore;
    }

    @Override
    public void add(T obj, Identity commitId) {
        super.add(obj, commitId);
    }

    @Override
    public void save(T obj, Identity commitId) {
        super.save(obj, commitId);
    }

    @Override
    public T ofIdentity(ID id) {
        return super.ofIdentity(id);
    }

    @Override
    protected EventStreamNameGenerator<T, ID> streamNameGenerator() {
        return esng;
    }

}