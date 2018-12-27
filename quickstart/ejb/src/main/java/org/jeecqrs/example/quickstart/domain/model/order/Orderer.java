package org.jeecqrs.example.quickstart.domain.model.order;

import org.apache.commons.lang3.Validate;
import org.jeecqrs.common.domain.model.ValueObject;

/**
 * Orderer.
 * Value object.
 */
public final class Orderer implements ValueObject<Orderer> {

    private final String name;

    public Orderer(String name) {
        Validate.notEmpty(name, "name must not be null or empty");
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    @Override
    public boolean sameValueAs(Orderer other) {
        return other != null && this.name.equals(other.name);
    }
    
}
