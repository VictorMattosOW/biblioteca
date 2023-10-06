package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.User;
import com.biblioteca.biblioteca.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public void save(User u) {
    this.repository.save(u);
  }

  public Optional<User> findById(Integer id) {
    return this.repository.findById(id);
  }

  public Iterable<User> findAll() {
    return this.repository.findAll();
  }

  public Optional<User> findByName(String name) {
    return this.repository.findByName(name);
  }
}
