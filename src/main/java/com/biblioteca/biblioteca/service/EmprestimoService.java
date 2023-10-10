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

  private final int qdteMaxLivros = 3;

  public Emprestimo createEmprestimo(Integer id_user, Integer id_book) {
    User user = findUser(id_user);
    Livro livro = findBook(id_book);

    if (livro.getQuantidade() < 1) {
      throw new IllegalArgumentException("Livro fora de estoque");
    }

    if (user.getBookList().size() >= this.qdteMaxLivros) {
      throw new IllegalArgumentException(
        "Você não pode pegar mais livros emprestados"
      );
    }

    livro.setQuantidade(livro.getQuantidade() - 1);
    user.getBookList().add(livro);

    Date now = new Date();
    Emprestimo emprestimo = new Emprestimo(id_user, id_book, now);
    return this.save(emprestimo);
  }

  private User findUser(Integer id) {
    Optional<User> existentUser = userRepository.findById(id);
    return existentUser.orElseThrow(() ->
      new IllegalArgumentException("Usuário não encontrado.")
    );
  }

  private Livro findBook(Integer id) {
    Optional<Livro> existentLivro = livroRepository.findById(id);
    return existentLivro.orElseThrow(() ->
      new IllegalArgumentException("Usuário não encontrado.")
    );
  }

  public Emprestimo save(Emprestimo emprestimo) {
    return this.emprestimoRepository.save(emprestimo);
  }
}
