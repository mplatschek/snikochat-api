package de.martinplatschek.snikochatapi.user.worker;

import de.martinplatschek.snikochatapi.user.objects.UserDao;

public interface UserWorker {
    boolean addUser(UserDao user);
    boolean loginUser(String username, String password);
    UserDao searchUserByName(String username);
}
