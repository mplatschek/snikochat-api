package de.martinplatschek.snikochatapi.message.worker;

import de.martinplatschek.snikochatapi.message.objects.MessageDao;
import de.martinplatschek.snikochatapi.message.repository.MessageRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Component
public class MessageWorkerImpl implements MessageWorker {
    private final MessageRepository repository;

    public MessageWorkerImpl(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MessageDao> getAllMessages() {
        return this.repository.findAll();
    }

    @Override
    public List<MessageDao> getMessagesByText(String text) {
        return this.repository.findByMessage(text);
    }

    @Override
    public boolean saveMessage(MessageDao msg) {
        boolean result = false;
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            msg.sender = user.getUsername();
            msg.sent = new Date();
            this.repository.save(msg);

            result = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }

    @Override
    public boolean deleteAllMessages() {
        boolean result = false;
        try {
            this.repository.deleteAll();
            result = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }
}
