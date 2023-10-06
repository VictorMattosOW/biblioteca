package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.User;
import com.biblioteca.biblioteca.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class UserController {

  @Autowired
  UserService service;

  @PostMapping
  public void post(@RequestBody User user) {
    service.save(user);
  }

  @GetMapping("/{id}")
  public Optional<User> findById(int id) {
    return service.findById(id);
  }

  @GetMapping
  public ResponseEntity<Iterable<User>> getAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/name")
  public ResponseEntity<Optional<User>> findByName(@RequestParam String name) {
    return ResponseEntity.ok(service.findByName(name));
  }
}
