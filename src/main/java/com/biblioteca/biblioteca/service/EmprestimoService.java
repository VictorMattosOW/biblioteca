package com.biblioteca.biblioteca.service;

import com.biblioteca.biblioteca.model.Emprestimo;
import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.model.User;
import com.biblioteca.biblioteca.repository.EmprestimoRepository;
import com.biblioteca.biblioteca.repository.UserRepository;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {

  @Autowired
  private EmprestimoRepository emprestimoRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private LivroService livroRepository;

  public Emprestimo createEmprestimo(Integer id_user, Integer id_book) {
    User user = this.findUser(id_user);
    Livro livro = this.findBook(id_book);
    livro.hasBookAtStock();
    user.pegaLivroEmprestado(livro);
    Date date = new Date();
    Emprestimo emprestimo = new Emprestimo(id_user, id_book, date);
    return this.save(emprestimo);
  }

  private User findUser(Integer id) {
    Optional<User> existentUser = this.userRepository.findById(id);
    if (existentUser.isPresent()) {
      return existentUser.get();
    } else {
      throw new IllegalArgumentException("Usuário não encontrado.");
    }
  }

  private Livro findBook(Integer id) {
    Optional<Livro> existenLivro = this.livroRepository.findById(id);
    if (existenLivro.isPresent()) {
      return existenLivro.get();
    } else {
      throw new IllegalArgumentException("Livro não encontrado.");
    }
  }

  public Emprestimo save(Emprestimo emprestimo) {
    return this.emprestimoRepository.save(emprestimo);
  }
}
