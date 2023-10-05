package com.biblioteca.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(unique = true)
  private String email;

  private String nome;
  private String telefone;
  private int qdteMaxLivos;
  private List<String> listaLivros;

  public Usuario() {}

  public Usuario(String nome, String email, String telefone) {
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
  }

  public List<String> getListaLivros() {
    return listaLivros;
  }

  public void setListaLivros(List<String> listaLivros) {
    this.listaLivros = listaLivros;
  }

  public int getQdteMaxLivos() {
    return qdteMaxLivos;
  }

  public void setQdteMaxLivos(int qdteMaxLivos) {
    this.qdteMaxLivos = qdteMaxLivos;
  }

  public Integer getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getNome() {
    return nome;
  }

  public String getTelefone() {
    return telefone;
  }
}
