package de.martinplatschek.snikochatapi.user.objects;

import java.util.Date;

public class UserDao {
    public String userid;
    public String username;
    public String password;
    public UserRolesEnum role;
    public Date registered;

    public UserDao() {
    }

    public UserDao(String userid, String username, String password, UserRolesEnum role, Date registered) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.role = role;
        this.registered = registered;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", registered=" + registered +
                '}';
    }
}
