package org.hibernate.examples.entityassociations.onetoone;

import org.hibernate.examples.base.HibernateTestCase;
import org.hibernate.examples.domain.entityassociations.onetoone.foreigngenerator.Address;
import org.hibernate.examples.domain.entityassociations.onetoone.foreigngenerator.User;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForeignGeneratorTest extends HibernateTestCase {

    @Test
    @Ignore
    public void storingUserAndAddress() {
        em.getTransaction().begin();

        User user = new User("jankowalski");
        Address address = new Address(user, "Sezamkowa", "61-215", "Poznan");
        user.setShippingAddress(address);
        em.persist(user);

        em.getTransaction().commit();

        Long userId = user.getId();
        Long addressId = address.getId();

        user = em.find(User.class, userId);
        address = em.find(Address.class, addressId);

        assertEquals(user.getShippingAddress().getCity(), "Poznan");
        assertEquals(address.getStreet(), "Sezamkowa");

        assertEquals(user.getId(), address.getId());

        assertEquals(address.getUser(), user);
    }
}
