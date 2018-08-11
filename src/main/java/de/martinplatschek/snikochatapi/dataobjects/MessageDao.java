package de.martinplatschek.snikochatapi.dataobjects;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class MessageDao {
    @Id
    public String id;

    public String sender;
    public Date sent;
    public String message;

    public MessageDao() { }

    public MessageDao(String sender, Date sent, String message) {
        this.sender = sender;
        this.sent = sent;
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageDao{" +
                "id='" + id + '\'' +
                ", sender='" + sender + '\'' +
                ", sent=" + sent +
                ", message='" + message + '\'' +
                '}';
    }
}
