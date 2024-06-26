package com.example.usersAdmin.dto;

import org.springframework.beans.BeanUtils;

import com.example.usersAdmin.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String login;
    private String password;

    public UserDto(UserEntity userEntity) {
        BeanUtils.copyProperties(userEntity, this);
    }
}
