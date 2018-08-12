package de.martinplatschek.snikochatapi.user.worker;

import de.martinplatschek.snikochatapi.user.objects.OnlineStatusEnum;
import de.martinplatschek.snikochatapi.user.objects.UserDao;
import de.martinplatschek.snikochatapi.user.objects.UserDto;
import de.martinplatschek.snikochatapi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserWorkerImpl implements UserWorker {
    private UserRepository repository;

    @Autowired
    public UserWorkerImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean addUser(UserDao user) {
        if (this.repository.findByUsername(user.name) != null) {
            return false;
        } else {
            this.repository.save(user);
            return true;
        }
    }

    @Override
    public boolean loginUser() {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDao user = this.repository.findByUsername(currentUser.getUsername());
        if (user != null) {
            user.status = OnlineStatusEnum.ONLINE;
            this.repository.save(user);
        }
        return user != null;
    }

    @Override
    public void logoutUser() {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDao user = this.repository.findByUsername(currentUser.getUsername());
        user.status = OnlineStatusEnum.OFFLINE;

        this.repository.save(user);
    }

    @Override
    public void deleteUser() {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public UserDto getUserByName(String name) {
        UserDao usr = this.repository.findByUsername(name);
        return new UserDto(usr.name, usr.role, usr.registered, usr.status);
    }

    @Override
    public List<UserDto> getOnlineUsers() {
        return null;
    }
}
