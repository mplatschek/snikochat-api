package de.martinplatschek.snikochatapi.message.worker;

import de.martinplatschek.snikochatapi.message.objects.MessageDto;

import java.util.List;

public interface MessageWorker {
    List<MessageDto> getAllMessages(String filter);
    void saveMessage(MessageDto message);
    void deleteAllMessages();
}
