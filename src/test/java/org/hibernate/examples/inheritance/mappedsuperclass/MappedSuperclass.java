package org.hibernate.examples.inheritance.mappedsuperclass;

import org.hibernate.examples.base.HibernateTestCase;
import org.hibernate.examples.domain.inheritance.mappedsuperclass.BankAccount;
import org.hibernate.examples.domain.inheritance.mappedsuperclass.BillingDetails;
import org.hibernate.examples.domain.inheritance.mappedsuperclass.CreditCard;
import org.junit.Test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MappedSuperclass extends HibernateTestCase {

    @Test
    public void savingBankAccountTest(){
        em.getTransaction().begin();

        BillingDetails bankAccount
                = new BankAccount("owner", "accountname", "pko", "pkoswift");
        em.persist(bankAccount);

        BillingDetails creditCard
                = new CreditCard("owner", "3423423-423423", "June", "2004");
        em.persist(creditCard);

        em.getTransaction().commit();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery criteria = cb.createQuery();
        criteria.select(criteria.from(BankAccount.class));
        Query query = em.createQuery(criteria);
        BillingDetails persistedBankAccount = (BillingDetails) query.getSingleResult();

        assertNotNull(persistedBankAccount);
        assertEquals("owner", persistedBankAccount.getOwner());

        CriteriaQuery criteria2 = cb.createQuery();
        criteria2.select(criteria2.from(CreditCard.class));
        Query query2 = em.createQuery(criteria2);
        BillingDetails persistedCreditCard = (BillingDetails) query2.getSingleResult();

        assertNotNull(persistedCreditCard);
        assertEquals("owner", persistedCreditCard.getOwner());
    }
}