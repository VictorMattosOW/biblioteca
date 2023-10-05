package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Usuario;
import com.biblioteca.biblioteca.service.UsuarioService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

  @Autowired
  UsuarioService service;

  @PostMapping
  public void post(@RequestBody Usuario usuario) {
    service.save(usuario);
  }

  @GetMapping("/{id}")
  public Optional<Usuario> findById(int id) {
    return service.findById(id);
  }

  @GetMapping
  public ResponseEntity<Iterable<Usuario>> getAll() {
    return ResponseEntity.ok(service.findAll());
  }
}
