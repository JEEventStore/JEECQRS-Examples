package org.jeecqrs.example.thorntail.port.adapter.persistence;

import org.jeecqrs.sagas.tracker.jpa.JPASagaTrackerPersistenceContextProvider;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
