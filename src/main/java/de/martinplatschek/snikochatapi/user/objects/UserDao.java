package de.martinplatschek.snikochatapi.user.objects;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class UserDao {
    @Id
    public String id;
    public String name;
    public String password;
    public UserRolesEnum role;
    public Date registered;
    public OnlineStatusEnum status;

    public UserDao() {
    }

    public UserDao(String name, String password, UserRolesEnum role, Date registered, OnlineStatusEnum status) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.registered = registered;
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", registered=" + registered +
                ", status=" + status +
                '}';
    }
}
