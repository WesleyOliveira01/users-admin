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

import com.example.usersAdmin.dto.RecursoDto;
import com.example.usersAdmin.service.RecursoService;

@RestController
@RequestMapping(value = "/v1/recurso")
@CrossOrigin
public class RecursoController {

    @Autowired
    private RecursoService service;

    @GetMapping
    public ResponseEntity<List<RecursoDto>> findAll() {
        try {
            List<RecursoDto> recursos = service.findAll();
            return ResponseEntity.ok(recursos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecursoDto> findById(@PathVariable Long id) {
        try {
            RecursoDto recurso = service.findById(id);
            return ResponseEntity.ok(recurso);
        } catch (Exception e) {

            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody RecursoDto recurso) {
        try {
            service.create(recurso);
            return ResponseEntity.ok(new String("Recurso created successfully"));
        } catch (Exception e) {

            return ResponseEntity.badRequest().body(null);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<RecursoDto> update(@PathVariable Long id, @RequestBody RecursoDto recurso) {
        try {
            service.update(id, recurso);
            return ResponseEntity.ok(recurso);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> delete(@PathVariable long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new String("Recurso deleted successfully"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }
}
