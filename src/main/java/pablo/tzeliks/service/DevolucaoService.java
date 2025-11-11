package pablo.tzeliks.service;

import pablo.tzeliks.infraestructure.DevolucaoRepository;
import pablo.tzeliks.model.Emprestimo;
import pablo.tzeliks.view.helper.MensagemHelper;

import java.sql.SQLException;

public class DevolucaoService {

    private DevolucaoRepository repository;

    public DevolucaoService(DevolucaoRepository repository) {
        this.repository = repository;
    }

    public void devolverLivro(Emprestimo emprestimo) {

        try {
            repository.updateLivroStatus(emprestimo);

        } catch (SQLException e) {

            MensagemHelper.erro("Erro ao registrar devolução do Livro, disponibilidade do Livro não conseguiu ser alterada, observe: " + e.getMessage());

            e.printStackTrace();
        }
    }
}