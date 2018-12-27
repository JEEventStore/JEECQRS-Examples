package org.jeecqrs.example.quickstart.port.adapter.persistence;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jeecqrs.sagas.tracker.jpa.JPASagaTrackerPersistenceContextProvider;

@Singleton
public class SagaTrackerPersistenceContextProvider implements JPASagaTrackerPersistenceContextProvider {

    @PersistenceContext(unitName="ExamplePU")
    private EntityManager entityManager;

    @Override
    @Lock(LockType.READ)
    public EntityManager entityManager() {
        return entityManager;
    }
    
}
