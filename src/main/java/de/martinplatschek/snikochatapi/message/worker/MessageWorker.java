package de.martinplatschek.snikochatapi.message.worker;

import de.martinplatschek.snikochatapi.message.objects.MessageDao;

import java.util.List;

public interface MessageWorker {
    List<MessageDao> getAllMessages();
    List<MessageDao> getMessagesByText(String text);
    boolean saveMessage(MessageDao msg);
    boolean deleteAllMessages();
}
