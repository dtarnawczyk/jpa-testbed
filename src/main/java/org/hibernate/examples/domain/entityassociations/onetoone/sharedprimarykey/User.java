package org.hibernate.examples.domain.entityassociations.onetoone.sharedprimarykey;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    protected Long id;

    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @PrimaryKeyJoinColumn
    protected Address shippingAddress;

    protected String username;

    protected User(){}

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
