package pablo.tzeliks.service;

import pablo.tzeliks.infraestructure.LivroRepository;
import pablo.tzeliks.model.Livro;
import pablo.tzeliks.view.helper.MensagemHelper;

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

            MensagemHelper.erro("Erro ao cadastrar livro, observe: " + e.getMessage());

            e.printStackTrace();
        }
    }
}