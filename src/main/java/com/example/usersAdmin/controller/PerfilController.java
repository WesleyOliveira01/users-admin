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

import com.example.usersAdmin.dto.PerfilDto;
import com.example.usersAdmin.service.PerfilService;


@RestController
@RequestMapping(value = "/v1/perfil")
@CrossOrigin
public class PerfilController {
    @Autowired
    private PerfilService service;

    @GetMapping
    public ResponseEntity<List<PerfilDto>> findAll() {
        List<PerfilDto> Perfil = service.findAll();
        return ResponseEntity.ok(Perfil);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilDto> findById(@PathVariable Long id) {
        try {
            PerfilDto Perfil = service.findById(id);
            return ResponseEntity.ok(Perfil);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PerfilDto> create(@RequestBody PerfilDto PerfilDto) {
        try {
            PerfilDto Perfil = service.create(PerfilDto);
            return ResponseEntity.ok(Perfil);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerfilDto> update(@PathVariable long id, @RequestBody PerfilDto PerfilDto) {
        try {
            PerfilDto updatedPerfil = service.update(id, PerfilDto);
            return ResponseEntity.ok(updatedPerfil);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
