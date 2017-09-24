package org.hibernate.examples.domain.entityassociations.bidirectional;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID", nullable = false)
    protected Item item;

    @NotNull
    protected BigDecimal amount;

    protected Bid(){}

    public Bid(Item item, BigDecimal amount) {
        this.item = item;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
