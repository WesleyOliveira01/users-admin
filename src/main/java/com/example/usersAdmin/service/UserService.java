package com.example.usersAdmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usersAdmin.dto.UserDto;
import com.example.usersAdmin.entity.UserEntity;
import com.example.usersAdmin.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<UserDto> findAll() {
        List<UserEntity> users = repository.findAll();
        return users.stream().map(UserDto::new).toList();
    }

    public void create(UserDto user) {
        UserEntity userEntity = new UserEntity(user);
        repository.save(userEntity);
    }

    public UserDto update(long id, UserDto user) {
        UserEntity userEntity = repository.findById(id).orElseThrow();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setLogin(user.getLogin());
        userEntity.setPassword(user.getPassword());
        repository.save(userEntity);
        return new UserDto(userEntity);
    }

    public void delete(Long id) {
        UserEntity userEntity = repository.findById(id).orElseThrow();

        repository.deleteById(userEntity.getId());
    }

    public UserDto findById(Long id) {
        UserEntity userEntity = repository.findById(id).get();
        return new UserDto(userEntity);
    }
}
