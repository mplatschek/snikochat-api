package de.martinplatschek.snikochatapi.user.repository;

import de.martinplatschek.snikochatapi.user.objects.UserDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<UserDao, String> {
    @Query("{'name': {$regex: ?0, $options: 'i'}})")
    UserDao findByUsername(String username);
}
