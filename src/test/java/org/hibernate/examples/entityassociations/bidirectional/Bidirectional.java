package org.hibernate.examples.entityassociations.bidirectional;

import org.hibernate.examples.base.HibernateTestCase;
import org.hibernate.examples.domain.entityassociations.bidirectional.Bid;
import org.hibernate.examples.domain.entityassociations.bidirectional.Item;
import org.junit.Test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class Bidirectional extends HibernateTestCase {

    @Test
    public void createBidOnItem(){
        em.getTransaction().begin();

        Item item = new Item("bike");
        Bid bid = new Bid(item, new BigDecimal("439.99"));

        em.persist(item);
        em.persist(bid);
        em.getTransaction().commit();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery criteria = cb.createQuery();

        criteria.select(criteria.from(Bid.class));

        Query query = em.createQuery(criteria);
        List<Bid> bidsList = query.getResultList();

        assertThat(bidsList.get(0).getItem().getName(), is("bike"));

    }

    @Test
    public void createBidsOnItem() {
        em.getTransaction().begin();

        Item item = new Item("bike");

        Bid bid1 = new Bid(item, new BigDecimal("439.99"));
        Bid bid2 = new Bid(item, new BigDecimal("440.00"));

        item.addBid(bid1);
        item.addBid(bid2);

        em.persist(item);
        em.persist(bid1);
        em.persist(bid2);
        em.getTransaction().commit();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery criteria = cb.createQuery();

        criteria.select(criteria.from(Item.class));

        Query query = em.createQuery(criteria);
        List<Item> itemList = query.getResultList();

        Item persistItem = itemList.get(0);
        Set<Bid> bids = persistItem.getBids();
        assertThat(bids, hasItems(bid1, bid2));
    }
}
