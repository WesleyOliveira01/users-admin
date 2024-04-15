package com.example.usersAdmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usersAdmin.dto.RecursoDto;
import com.example.usersAdmin.service.RecursoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/v1/recurso")
public class RecursoController {

    @Autowired
    private RecursoService service;

    @GetMapping
    public List<RecursoDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RecursoDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public void create(@RequestBody RecursoDto recurso) {
        service.create(recurso);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody RecursoDto recurso) {
        service.update(id, recurso);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
