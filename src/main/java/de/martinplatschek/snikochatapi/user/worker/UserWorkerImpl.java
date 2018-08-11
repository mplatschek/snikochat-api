package de.martinplatschek.snikochatapi.user.worker;

import de.martinplatschek.snikochatapi.user.objects.UserDao;
import de.martinplatschek.snikochatapi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserWorkerImpl implements UserWorker {
    private UserRepository repository;

    @Autowired
    public UserWorkerImpl(UserRepository repository) {
        this.repository = repository;
    }

    public boolean addUser(UserDao user) {
        boolean result = false;
        try {
            this.repository.save(user);
            result = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;
    }

    @Override
    public boolean loginUser(String username, String password) {
        return false;
    }

    public UserDao searchUserByName(String name) {
        return this.repository.findByUsername(name);
    }
}
