package org.jeecqrs.example.quickstart.port.adapter.persistence;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jeeventstore.persistence.jpa.PersistenceContextProvider;

@Singleton
public class JEEventStorePersistenceContextProvider implements PersistenceContextProvider {

    @PersistenceContext(unitName="ExamplePU")
    private EntityManager entityManager;

    @Override
    @Lock(LockType.READ)
    public EntityManager entityManagerForReading(String bucketId) {
        return entityManager;
    }

    @Override
    @Lock(LockType.READ)
    public EntityManager entityManagerForWriting(String bucketId) {
        return entityManager;
    }
    
}
