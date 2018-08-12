package de.martinplatschek.snikochatapi.user;

import de.martinplatschek.snikochatapi.user.objects.UserDao;
import de.martinplatschek.snikochatapi.user.worker.UserWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApi {
    private final UserWorker userWorker;

    @Autowired
    public UserApi(UserWorker userWorker) {
        this.userWorker = userWorker;
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> setUser(@RequestBody UserDao user) {
        return new ResponseEntity<>(this.userWorker.addUser(user) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/login")
    public ResponseEntity<HttpStatus> loginUser() {
        return new ResponseEntity<>(this.userWorker.loginUser() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/logout")
    public ResponseEntity<HttpStatus> logoutUser() {
        this.userWorker.logoutUser();
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteUser() {
        this.userWorker.deleteUser();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
