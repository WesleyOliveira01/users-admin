package com.example.usersAdmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usersAdmin.dto.PerfilDto;
import com.example.usersAdmin.entity.PerfilEntity;
import com.example.usersAdmin.repository.PerfilRepository;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository repository;

    public List<PerfilDto> findAll() {
        List<PerfilEntity> Perfil = repository.findAll();
        return Perfil.stream().map(PerfilDto::new).toList();
    }

    public PerfilDto findById(Long id) {
        PerfilEntity PerfilEntity = repository.findById(id).get();
        return new PerfilDto(PerfilEntity);
    }

    public PerfilDto create(PerfilDto PerfilDto) {
        PerfilEntity PerfilEntity = new PerfilEntity(PerfilDto);
        repository.save(PerfilEntity);
        return new PerfilDto(PerfilEntity);
    }

    public PerfilDto update(Long id, PerfilDto PerfilDto) {
        PerfilEntity PerfilEntity = repository.findById(id).orElseThrow();
        PerfilEntity.setDescricao(PerfilDto.getDescricao());
        repository.save(PerfilEntity);
        return new PerfilDto(PerfilEntity);
    }

    public void delete(Long id) {
        var Perfil = repository.findById(id).orElseThrow();
        repository.delete(Perfil);
    }
}
