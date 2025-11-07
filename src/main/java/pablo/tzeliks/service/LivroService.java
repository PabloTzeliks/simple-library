package pablo.tzeliks.service;

import pablo.tzeliks.infraestructure.LivroRepository;
import pablo.tzeliks.model.Livro;
import pablo.tzeliks.view.helper.MensagemHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Livro> listarLivros() {

        List<Livro> livros = new ArrayList<>();

        try {
            livros = repository.list();

            if(livros.isEmpty()) {
                MensagemHelper.erro("Nenhum livro encontrado!");
            }

            return livros;

        } catch (SQLException e) {

            MensagemHelper.erro("Erro ao listar os livros, observe: " + e.getMessage());

            e.printStackTrace();
        }

        return null;
    }

    public void alterarDisponibilidade(Livro livro) {

        try {
            repository.updateDisponibilidade(livro);
        } catch (SQLException e) {

            MensagemHelper.erro("Erro ao alterar disponibilidade do Livro, observe: " + e.getMessage());
        }
    }
}