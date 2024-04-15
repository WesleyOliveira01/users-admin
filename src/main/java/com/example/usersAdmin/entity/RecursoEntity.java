package com.example.usersAdmin.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.example.usersAdmin.dto.RecursoDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_recurso")
public class RecursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String key;

    public RecursoEntity() {
    }

    public RecursoEntity(RecursoDto recursoDto) {
        BeanUtils.copyProperties(recursoDto, this);
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RecursoEntity)) {
            return false;
        }
        RecursoEntity recursoEntity = (RecursoEntity) o;
        return Objects.equals(id, recursoEntity.id) && Objects.equals(name, recursoEntity.name)
                && Objects.equals(key, recursoEntity.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, key);
    }

}
