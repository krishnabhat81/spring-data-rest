package com.spring.data.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.data.core.BaseEntity;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

/**
 * Created by krishna1bhat on 5/1/17.
 */

@Data
@Entity
public class User extends BaseEntity {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private String firstName;
    private String lastName;
    private String userName;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String[] roles;

    protected User(){
        super();
    }

    public User(String firstName, String lastName, String userName, String password, String[] roles) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        setPassword(password);
        this.roles = roles;
    }

    public void setPassword(String password){
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String[] getRoles() {
        return roles;
    }
}
