package de.martinplatschek.snikochatapi.user.repository;

import de.martinplatschek.snikochatapi.user.objects.UserDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<UserDao, String> {
    @Query("{'username': {$regex: ?0, $options: 'i'}})")
    UserDao findByUsername(String username);

    @Query("{'userid': {$regex: ?0, $options: 'i'}})")
    UserDao findByUserId(String userId);
}
