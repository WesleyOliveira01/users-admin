package com.example.usersAdmin.dto;

import org.springframework.beans.BeanUtils;

import com.example.usersAdmin.entity.RecursoEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecursoDto {
    private Long id;
    private String name;
    private String key;

    public RecursoDto(RecursoEntity recursoEntity) {
        BeanUtils.copyProperties(recursoEntity, this);
    }
}
