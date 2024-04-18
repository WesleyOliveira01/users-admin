package com.example.usersAdmin.dto;

import org.springframework.beans.BeanUtils;

import com.example.usersAdmin.entity.PerfilEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerfilDto {

    private Long id;
    private String descricao;

    public PerfilDto(PerfilEntity perfilEntity) {
        BeanUtils.copyProperties(perfilEntity, this);
    }
}
