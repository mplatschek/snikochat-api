package de.martinplatschek.snikochatapi.message.worker;

import de.martinplatschek.snikochatapi.message.objects.MessageDao;
import de.martinplatschek.snikochatapi.message.objects.MessageDto;
import de.martinplatschek.snikochatapi.message.repository.MessageRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MessageWorkerImpl implements MessageWorker {
    private final MessageRepository repository;

    public MessageWorkerImpl(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MessageDto> getAllMessages(String filter) {
        List<MessageDao> resultDatabase = filter.equals("") ? this.repository.findAll() : this.repository.findByMessage(filter);
        ArrayList<MessageDto> result = new ArrayList<>();
        resultDatabase.forEach(dao -> result.add(new MessageDto(dao.text, dao.sender, dao.sent)));

        return result;
    }

    @Override
    public void saveMessage(MessageDto msg) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MessageDao dao = new MessageDao(user.getUsername(), new Date(), msg.text);

        this.repository.save(dao);
    }

    @Override
    public void deleteAllMessages() {
        this.repository.deleteAll();
    }
}
