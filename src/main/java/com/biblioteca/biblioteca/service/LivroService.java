package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

  @Autowired
  private LivroRepository repository;

  public void save(Livro l) {
    this.repository.save(l);
  }

  public Iterable<Livro> findAll() {
    return this.repository.findAll();
  }

  public Livro findByName(String name) {
    return this.repository.findByName(name);
  }
}
