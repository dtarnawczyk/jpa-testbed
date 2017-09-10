package org.hibernate.examples.domain.inheritance.mappedsuperclass;
import com.sun.istack.internal.NotNull;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BillingDetails {

    @NotNull
    protected String owner;

    protected BillingDetails(){}

    public BillingDetails(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}


