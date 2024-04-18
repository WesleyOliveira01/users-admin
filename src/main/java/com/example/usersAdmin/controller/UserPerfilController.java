package com.example.usersAdmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usersAdmin.dto.UserPerfilDto;
import com.example.usersAdmin.service.UserPerfilService;

@RestController
@RequestMapping(value = "/v1/userPerfil")
@CrossOrigin
public class UserPerfilController {
    @Autowired
    private UserPerfilService service;

    @GetMapping
    public ResponseEntity<List<UserPerfilDto>> findAll() {
        List<UserPerfilDto> userPerfil = service.findAll();
        return ResponseEntity.ok(userPerfil);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPerfilDto> findById(@PathVariable Long id) {
        try {
            UserPerfilDto userPerfil = service.findById(id);
            return ResponseEntity.ok(userPerfil);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UserPerfilDto> create(@RequestBody UserPerfilDto userPerfilDto) {
        try {
            UserPerfilDto userPerfil = service.create(userPerfilDto);
            return ResponseEntity.ok(userPerfil);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserPerfilDto> update(@PathVariable long id, UserPerfilDto userPerfilDto) {
        try {
            UserPerfilDto updatedUserPerfil = service.update(id, userPerfilDto);
            return ResponseEntity.ok(updatedUserPerfil);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
