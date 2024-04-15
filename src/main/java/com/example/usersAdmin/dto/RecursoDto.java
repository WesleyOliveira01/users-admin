package com.example.usersAdmin.dto;

import org.springframework.beans.BeanUtils;

import com.example.usersAdmin.entity.RecursoEntity;

public class RecursoDto {
    private Long id;
    private String name;
    private String key;

    public RecursoDto() {
    }

    public RecursoDto(RecursoEntity recursoEntity) {
        BeanUtils.copyProperties(recursoEntity, this);
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

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
