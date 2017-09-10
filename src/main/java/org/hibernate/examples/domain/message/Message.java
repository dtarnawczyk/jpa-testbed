package org.hibernate.examples.domain.message;

import javax.persistence.*;

@Entity
@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(name = "Message.getAll", query = "SELECT b FROM Message b")
})
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    protected Message(){}

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message {" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
