package de.martinplatschek.snikochatapi.message.repository;

import de.martinplatschek.snikochatapi.message.objects.MessageDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MessageRepository extends MongoRepository<MessageDao, String> {
    @Query("{'text': {$regex: ?0, $options: 'i'}})")
    List<MessageDao> findByMessage(String message);
}
