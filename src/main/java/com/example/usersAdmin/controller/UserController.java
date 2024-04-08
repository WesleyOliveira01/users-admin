package com.example.usersAdmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.usersAdmin.dto.UserDto;
import com.example.usersAdmin.service.UserService;



@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<UserDto> findAll() {
        var users = service.findAll();
        return users;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findByID(@PathVariable long id) {
        try {
            var user = service.findById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateByID(@PathVariable long id, @RequestBody UserDto userDto) {
        try {
            var user = service.update(id,userDto);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new String("User not found"));
        }
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UserDto user) {
        try {
            service.create(user);
            return ResponseEntity.ok(new String("User created with sucess"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new String(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteByID(@PathVariable long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new String("User deleted with sucess"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new String("User not found"));
        }
    }

}
