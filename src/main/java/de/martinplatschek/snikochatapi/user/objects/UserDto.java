package de.martinplatschek.snikochatapi.user.objects;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class UserDto {
    public String name;
    public UserRolesEnum role;
    public Date registered;
    public OnlineStatusEnum status;

    public UserDto() { }

    public UserDto(String name, UserRolesEnum role, Date registered, OnlineStatusEnum status) {
        this.name = name;
        this.role = role;
        this.registered = registered;
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", role=" + role +
                ", registered=" + registered +
                ", status=" + status +
                '}';
    }
}
