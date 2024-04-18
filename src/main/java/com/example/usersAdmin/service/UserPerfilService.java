package com.example.usersAdmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usersAdmin.dto.UserPerfilDto;
import com.example.usersAdmin.entity.UserPerfilEntity;
import com.example.usersAdmin.repository.UserPerfilRepository;

@Service
public class UserPerfilService {
    @Autowired
    private UserPerfilRepository repository;

    public List<UserPerfilDto> findAll() {
        List<UserPerfilEntity> userPerfil = repository.findAll();
        return userPerfil.stream().map(UserPerfilDto::new).toList();
    }

    public UserPerfilDto findById(Long id) {
        UserPerfilEntity userPerfilEntity = repository.findById(id).get();
        return new UserPerfilDto(userPerfilEntity);
    }

    public UserPerfilDto create(UserPerfilDto userPerfilDto) {
        UserPerfilEntity userPerfilEntity = new UserPerfilEntity(userPerfilDto);
        repository.save(userPerfilEntity);
        return new UserPerfilDto(userPerfilEntity);
    }

    public UserPerfilDto update(Long id, UserPerfilDto userPerfilDto) {
        UserPerfilEntity userPerfilEntity = repository.findById(id).orElseThrow();
        UserPerfilEntity userPerfil = new UserPerfilEntity(userPerfilDto);
        userPerfilEntity.setUser(userPerfil.getUser());
        userPerfilEntity.setPerfil(userPerfil.getPerfil());
        repository.save(userPerfilEntity);
        return new UserPerfilDto(userPerfilEntity);
    }

    public void delete(Long id) {
        var userPerfil = repository.findById(id).orElseThrow();
        repository.delete(userPerfil);
    }
}
