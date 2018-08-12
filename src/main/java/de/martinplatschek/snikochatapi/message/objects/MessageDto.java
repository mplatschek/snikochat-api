package de.martinplatschek.snikochatapi.message.objects;

import java.util.Date;

public class MessageDto {
    public String text;
    public String sender;
    public Date sent;

    public MessageDto() {
    }

    public MessageDto(String text, String sender, Date sent) {
        this.text = text;
        this.sender = sender;
        this.sent = sent;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "text='" + text + '\'' +
                ", sender='" + sender + '\'' +
                ", sent='" + sent + '\'' +
                '}';
    }
}
