package pablo.tzeliks.service;

import pablo.tzeliks.infraestructure.LivroRepository;
import pablo.tzeliks.model.Livro;

import java.sql.SQLException;
import java.util.Scanner;

public class LivroService {

    private LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public void cadastrarLivro(Livro livro) {

        try {
            repository.save(livro);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
