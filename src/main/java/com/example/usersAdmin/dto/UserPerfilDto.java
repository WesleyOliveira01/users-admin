package com.example.usersAdmin.dto;

import org.springframework.beans.BeanUtils;

import com.example.usersAdmin.entity.UserPerfilEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPerfilDto {
    private Long id;
    private UserDto user;
    private PerfilDto perfil;

    public UserPerfilDto(UserPerfilEntity userPerfilEntity) {
        BeanUtils.copyProperties(userPerfilEntity, this);
    }

}
