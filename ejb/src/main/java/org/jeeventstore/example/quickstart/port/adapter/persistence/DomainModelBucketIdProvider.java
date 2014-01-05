package org.jeeventstore.example.quickstart.port.adapter.persistence;

import org.jeecqrs.integration.jcommondomain.jeeventstore.RegisterBucketId;

public class DomainModelBucketIdProvider implements RegisterBucketId {

    @Override
    public String bucketId() {
        return Resources.DOMAIN_BUCKET_ID;
    }

    @Override
    public boolean autoDispatch() {
        return true;
    }

    @Override
    public boolean autoReplay() {
        return true;
    }
    
}
