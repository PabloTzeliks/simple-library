package pablo.tzeliks.service;

import pablo.tzeliks.infraestructure.EmprestimoRepository;
import pablo.tzeliks.infraestructure.LivroRepository;
import pablo.tzeliks.model.Emprestimo;
import pablo.tzeliks.model.Livro;
import pablo.tzeliks.view.helper.MensagemHelper;

import java.sql.SQLException;

public class EmprestimoService {

    private EmprestimoRepository repository;

    public EmprestimoService(EmprestimoRepository repository) {
        this.repository = repository;
    }

    public void emprestarLivro(Emprestimo emprestimo) {

        try {
            repository.save(emprestimo);

        } catch (SQLException e) {

            MensagemHelper.erro("Erro ao registrar empréstimo do Livro, observe: " + e.getMessage());

            e.printStackTrace();
        }
    }
}
