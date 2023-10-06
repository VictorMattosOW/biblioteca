package com.biblioteca.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livro {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "name")
  private String name;

  private String autor;
  private int quantidade;

  public Livro() {}

  public Livro(String name, String autor, int quantidade) {
    this.name = name;
    this.autor = autor;
    this.quantidade = quantidade;
  }

  public String getAutor() {
    return autor;
  }

  public String getName() {
    return name;
  }

  public Integer getId() {
    return id;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void hasBookAtStock() {
    System.out.println(this.quantidade);
    if (this.quantidade >= 1) {
      this.quantidade--;
    } else {
      throw new IllegalArgumentException("Livro fora de estoque");
    }
  }
}
