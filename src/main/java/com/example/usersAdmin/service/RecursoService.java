package com.example.usersAdmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usersAdmin.dto.RecursoDto;
import com.example.usersAdmin.entity.RecursoEntity;
import com.example.usersAdmin.repository.RecursoRepository;

@Service
public class RecursoService {
    @Autowired
    private RecursoRepository repository;

    public List<RecursoDto> findAll() {
        List<RecursoEntity> recursos = repository.findAll();
        return recursos.stream().map(RecursoDto::new).toList();
    }

    public void create(RecursoDto recurso) {
        RecursoEntity recursoEntity = new RecursoEntity(recurso);
        repository.save(recursoEntity);
    }

    public void delete(Long id) {
        repository.findById(id).orElseThrow();
    }

    public RecursoDto findById(Long id) {
        RecursoEntity recursoEntity = repository.findById(id).get();
        return new RecursoDto(recursoEntity);
    }

    public void update(Long id, RecursoDto recurso) {
        RecursoEntity recursoEntity = repository.findById(id).orElseThrow();
        recursoEntity.setName(recurso.getName());
        recursoEntity.setKey(recurso.getKey());
        repository.save(recursoEntity);
    }
}
