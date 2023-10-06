package com.biblioteca.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(unique = true)
  private String email;

  @Column(name = "user_name")
  private String name;

  private String telefone;
  private int qdteMaxLivos = 3;

  @ManyToMany
  private List<Livro> bookList;

  public User() {}

  public User(String name, String email, String telefone) {
    this.name = name;
    this.email = email;
    this.telefone = telefone;
  }

  public List<Livro> getListBooks() {
    return bookList;
  }

  public void setBookList(List<Livro> bookList) {
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

  private boolean podePegarLivro() {
    return this.bookList.size() <= this.qdteMaxLivos;
  }

  public void pegaLivroEmprestado(Livro livro) {
    if (podePegarLivro()) {
      this.bookList.add(livro);
    } else {
      throw new IllegalArgumentException(
        "Você não pode pegar livro emprestado"
      );
    }
  }
}
