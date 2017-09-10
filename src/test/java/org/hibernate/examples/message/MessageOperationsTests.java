package org.hibernate.examples.message;

import org.h2.tools.RunScript;
import org.hibernate.Session;
import org.hibernate.examples.base.HibernateTestCase;
import org.hibernate.examples.domain.message.Message;
import org.hibernate.jdbc.Work;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class MessageOperationsTests extends HibernateTestCase {

    @Before
    public void initializeDatabase(){
        Session session = em.unwrap(Session.class);
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                try {
                    File script = new File(getClass().getResource("/data.sql").getFile());
                    RunScript.execute(connection, new FileReader(script));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException("could not initialize with script");
                }
            }
        });
    }

    @Test
    public void testGetObjectById_success() {
        Message message = em.find(Message.class, 1L);
        assertNotNull(message);
    }

    @Test
    public void testGetAll_success() {
        List<Message> messages = em.createNamedQuery("Message.getAll", Message.class).getResultList();
        assertEquals(1, messages.size());
    }

    @Test
    public void testPersist_success() {
        em.getTransaction().begin();
        em.persist(new Message("Unit Test Hibernate/JPA with in memory H2 Database"));
        em.getTransaction().commit();

        List<Message> messages = em.createNamedQuery("Message.getAll", Message.class).getResultList();

        assertNotNull(messages);
        assertEquals(2, messages.size());
    }

    @Test
    public void testDelete_success(){
        Message message = em.find(Message.class, 1L);

        em.getTransaction().begin();
        em.remove(message);
        em.getTransaction().commit();

        List<Message> messages = em.createNamedQuery("Message.getAll", Message.class).getResultList();

        assertEquals(0, messages.size());
    }

}