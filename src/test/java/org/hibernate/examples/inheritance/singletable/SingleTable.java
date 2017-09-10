package org.hibernate.examples.inheritance.singletable;

import org.hibernate.examples.base.HibernateTestCase;
import org.hibernate.examples.domain.inheritance.singletable.BankAccount3;
import org.hibernate.examples.domain.inheritance.singletable.BillingDetails3;
import org.hibernate.examples.domain.inheritance.singletable.CreditCard3;
import org.junit.Test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SingleTable extends HibernateTestCase{

    @Test
    public void savingBankAccountTest(){
        em.getTransaction().begin();

        BillingDetails3 bankAccount
                = new BankAccount3("owner", "accountname", "pko", "pkoswift");
        em.persist(bankAccount);

        BillingDetails3 creditCard
                = new CreditCard3("owner", "3423423-423423", "June", "2004");
        em.persist(creditCard);

        em.getTransaction().commit();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery criteria = cb.createQuery();

        criteria.select(criteria.from(BillingDetails3.class));

        Query query = em.createQuery(criteria);
        List<BillingDetails3> billingDetailsList = query.getResultList();

        assertNotNull(billingDetailsList);
        assertEquals(2, billingDetailsList.size());
    }
}
