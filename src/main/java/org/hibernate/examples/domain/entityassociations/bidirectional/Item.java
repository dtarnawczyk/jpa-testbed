package org.hibernate.examples.domain.entityassociations.bidirectional;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    protected String name;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    protected Set<Bid> bids = new HashSet<>();

    public Item(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBid(Bid bid) {
        bids.add(bid);
    }

    public Set<Bid> getBids() {
        return this.bids;
    }
}
