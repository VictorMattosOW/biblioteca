package com.biblioteca.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Emprestimo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  Date dataEmprestimo;
  Date dataDevolucao;
  UUID id_pessoa;
  UUID id_livro;

  public Emprestimo() {}

  public Emprestimo(Date dataEmprestimo, UUID id_pessoa, UUID id_livro) {
    this.dataEmprestimo = dataEmprestimo;
    this.id_pessoa = id_pessoa;
    this.id_livro = id_livro;
  }
}
