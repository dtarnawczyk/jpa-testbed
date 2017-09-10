package org.hibernate.examples.inheritance.tableperclass;

import org.hibernate.examples.base.HibernateTestCase;
import org.hibernate.examples.domain.inheritance.tableperclass.BankAccount2;
import org.hibernate.examples.domain.inheritance.tableperclass.BillingDetails2;
import org.hibernate.examples.domain.inheritance.tableperclass.CreditCard2;
import org.junit.Test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TablePerClass extends HibernateTestCase {

    @Test
    public void savingBankAccountTest(){
        em.getTransaction().begin();

        BillingDetails2 bankAccount
                = new BankAccount2("owner", "accountname", "pko", "pkoswift");
        em.persist(bankAccount);

        BillingDetails2 creditCard
                = new CreditCard2("owner", "3423423-423423", "June", "2004");
        em.persist(creditCard);

        em.getTransaction().commit();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery criteria = cb.createQuery();

        criteria.select(criteria.from(BillingDetails2.class));

        Query query = em.createQuery(criteria);
        List<BillingDetails2> billingDetailsList = query.getResultList();

        assertNotNull(billingDetailsList);
        assertEquals(2, billingDetailsList.size());
    }
}
