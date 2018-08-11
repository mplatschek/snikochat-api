package de.martinplatschek.snikochatapi.repository;

import de.martinplatschek.snikochatapi.dataobjects.MessageDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MessagesRepository extends MongoRepository<MessageDao, String> {
    @Query("{'message': {$regex: ?0, $options: 'i'}})")
    List<MessageDao> findByMessage(String message);
}
