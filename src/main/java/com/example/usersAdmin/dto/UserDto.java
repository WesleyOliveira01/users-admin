package com.example.usersAdmin.dto;

import org.springframework.beans.BeanUtils;

import com.example.usersAdmin.entity.UserEntity;

public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String login;
    private String password;

    public UserDto() {
    }

    public UserDto(UserEntity userEntity) {
        BeanUtils.copyProperties(userEntity, this);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
