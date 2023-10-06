package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Emprestimo;
import com.biblioteca.biblioteca.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emprestimo")
public class EmprestimoController {

  @Autowired
  EmprestimoService service;

  @PostMapping
  public void post(@RequestBody Emprestimo emprestimo) {
    service.createEmprestimo(
      emprestimo.getId_pessoa(),
      emprestimo.getId_livro()
    );
  }
}
