package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Usuario;
import com.biblioteca.biblioteca.repository.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository repository;

  public void save(Usuario u) {
    this.repository.save(u);
  }

  public Optional<Usuario> findById(Integer id) {
    return this.repository.findById(id);
  }

  public Iterable<Usuario> findAll() {
    return this.repository.findAll();
  }
}
