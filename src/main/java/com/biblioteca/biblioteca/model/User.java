package com.biblioteca.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(unique = true)
  private String email;

  private String name;
  private String telefone;
  private int qdteMaxLivos;
  private List<String> bookList;

  public User() {}

  public User(String name, String email, String telefone) {
    this.name = name;
    this.email = email;
    this.telefone = telefone;
  }

  public List<String> getListBooks() {
    return bookList;
  }

  public void SetBookList(List<String> bookList) {
    this.bookList = bookList;
  }

  public Integer getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public String getTelefone() {
    return telefone;
  }
}
