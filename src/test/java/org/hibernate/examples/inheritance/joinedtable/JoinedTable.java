package org.hibernate.examples.inheritance.joinedtable;

import org.hibernate.examples.base.HibernateTestCase;
import org.hibernate.examples.domain.inheritance.joinedtable.BankAccount4;
import org.hibernate.examples.domain.inheritance.joinedtable.BillingDetails4;
import org.hibernate.examples.domain.inheritance.joinedtable.CreditCard4;
import org.junit.Test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JoinedTable extends HibernateTestCase{

    @Test
    public void savingBankAccountTest(){
        em.getTransaction().begin();

        BillingDetails4 bankAccount
                = new BankAccount4("owner", "accountname", "pko", "pkoswift");
        em.persist(bankAccount);

        BillingDetails4 creditCard
                = new CreditCard4("owner", "3423423-423423", "June", "2004");
        em.persist(creditCard);

        em.getTransaction().commit();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery criteria = cb.createQuery();

        criteria.select(criteria.from(BillingDetails4.class));

        Query query = em.createQuery(criteria);
        List<BillingDetails4> billingDetailsList = query.getResultList();

        assertNotNull(billingDetailsList);
        assertEquals(2, billingDetailsList.size());
    }
}
