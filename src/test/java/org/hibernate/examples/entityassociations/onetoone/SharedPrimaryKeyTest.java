package org.hibernate.examples.entityassociations.onetoone;

import org.hibernate.examples.base.HibernateTestCase;
import org.hibernate.examples.domain.entityassociations.onetoone.sharedprimarykey.Address;
import org.hibernate.examples.domain.entityassociations.onetoone.sharedprimarykey.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SharedPrimaryKeyTest extends HibernateTestCase {

    @Test
    public void storingUserAndAddress() {
        em.getTransaction().begin();

        Address address = new Address("Sezamkowa", "61-215", "Poznan");
        em.persist(address);

        User user = new User(address.getId(), "jankowalski");
        user.setShippingAddress(address);
        em.persist(user);

        em.getTransaction().commit();

        Long userId = user.getId();
        Long addressId = address.getId();

        user = em.find(User.class, userId);
        address = em.find(Address.class, addressId);

        assertEquals(user.getId(), address.getId());

        assertEquals(user.getShippingAddress().getCity(), "Poznan");
        assertEquals(address.getStreet(), "Sezamkowa");
    }
}
