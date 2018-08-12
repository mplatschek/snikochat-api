package de.martinplatschek.snikochatapi.message.objects;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

public class MessageDao {
    @Id
    public String id;

    public String sender;
    public Date sent;
    public String text;

    public MessageDao() { }

    public MessageDao(String sender, Date sent, String text) {
        this.id = UUID.randomUUID().toString();
        this.sender = sender;
        this.sent = sent;
        this.text = text;
    }

    @Override
    public String toString() {
        return "MessageDao{" +
                "id='" + id + '\'' +
                ", sender='" + sender + '\'' +
                ", sent=" + sent +
                ", text='" + text + '\'' +
                '}';
    }
}
