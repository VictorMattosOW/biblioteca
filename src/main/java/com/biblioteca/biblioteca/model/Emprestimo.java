package com.biblioteca.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Emprestimo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  Date dataEmprestimo;
  Date dataDevolucao;
  Integer id_pessoa;
  Integer id_livro;

  public Emprestimo() {}

  public Emprestimo(Integer id_pessoa, Integer id_livro, Date dataEmprestimo) {
    this.id_pessoa = id_pessoa;
    this.id_livro = id_livro;
    this.dataEmprestimo = dataEmprestimo;
  }

  public Emprestimo(Date dataDevolucao, Integer id_pessoa, Integer id_livro) {
    this.dataDevolucao = dataDevolucao;
    this.id_pessoa = id_pessoa;
    this.id_livro = id_livro;
  }

  public Emprestimo(Integer id_pessoa, Integer id_livro) {
    this.id_pessoa = id_pessoa;
    this.id_livro = id_livro;
  }

  public Integer getId_livro() {
    return id_livro;
  }

  public Integer getId_pessoa() {
    return id_pessoa;
  }
}
