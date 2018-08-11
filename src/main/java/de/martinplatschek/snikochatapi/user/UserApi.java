package de.martinplatschek.snikochatapi.user;

import de.martinplatschek.snikochatapi.user.objects.UserDao;
import de.martinplatschek.snikochatapi.user.worker.UserWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApi {
    private final UserWorker userWorker;

    @Autowired
    public UserApi(UserWorker userWorker) {
        this.userWorker = userWorker;
    }

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> setUser(@RequestBody UserDao user) {
        return this.userWorker.addUser(user) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/login")
    public ResponseEntity<HttpStatus> loginUser(@RequestBody UserDao user) {
        return this.userWorker.loginUser(user.username, user.password) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
