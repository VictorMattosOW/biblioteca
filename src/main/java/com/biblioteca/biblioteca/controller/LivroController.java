package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("livros")
public class LivroController {

  @Autowired
  LivroService service;

  @PostMapping("/create")
  public void save(@RequestBody Livro livro) {
    this.service.save(livro);
  }

  @GetMapping
  public ResponseEntity<Iterable<Livro>> getAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/name")
  public ResponseEntity<Livro> getLivroByName(@RequestParam String name) {
    return ResponseEntity.ok(service.findByName(name));
  }
}
