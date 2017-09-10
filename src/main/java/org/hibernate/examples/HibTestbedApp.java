package org.hibernate.examples;

import org.hibernate.examples.domain.message.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class HibTestbedApp {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("hibernate-persistence-example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Message message = new Message("test message");
        entityManager.persist(message);

        entityManager.getTransaction().commit();

        List<Message> messages = entityManager.createNamedQuery("Message.getAll", Message.class).getResultList();

        messages.stream().forEach(m -> System.out.println(">>> "+m.getText()));

        entityManager.close();
        entityManagerFactory.close();
    }
}
