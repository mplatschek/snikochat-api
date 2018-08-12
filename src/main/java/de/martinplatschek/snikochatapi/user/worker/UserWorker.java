package de.martinplatschek.snikochatapi.user.worker;

import de.martinplatschek.snikochatapi.user.objects.UserDao;
import de.martinplatschek.snikochatapi.user.objects.UserDto;

import java.util.List;

public interface UserWorker {
    boolean addUser(UserDao user);
    boolean loginUser();
    void logoutUser();
    void deleteUser();
    UserDto getUserByName(String username);
    List<UserDto> getOnlineUsers();
}
