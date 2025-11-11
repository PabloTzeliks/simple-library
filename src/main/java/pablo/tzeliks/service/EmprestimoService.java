package pablo.tzeliks.service;

import pablo.tzeliks.infraestructure.EmprestimoRepository;
import pablo.tzeliks.model.Emprestimo;
import pablo.tzeliks.view.helper.MensagemHelper;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoService {

    private EmprestimoRepository repository;

    public EmprestimoService(EmprestimoRepository repository) {
        this.repository = repository;
    }

    public void emprestarLivro(Emprestimo emprestimo) {

        LocalDate dataAtual =  LocalDate.now();

        if (dataAtual.isEqual(emprestimo.getDataDevolucao()) || dataAtual.isAfter(emprestimo.getDataDevolucao())) {

            MensagemHelper.erro("Erro na inserção da Data de Devolução, data inserida inválida.");
            return;
        }

        try {
            repository.save(emprestimo);

        } catch (SQLException e) {

            MensagemHelper.erro("Erro ao registrar empréstimo do Livro, observe: " + e.getMessage());

            e.printStackTrace();
        }
    }

    public List<Emprestimo> listarEmprestimos() {

        List<Emprestimo> emprestimos = new ArrayList<>();

        try {
            emprestimos = repository.list();

            if(emprestimos.isEmpty()) {
                MensagemHelper.erro("Nenhum empréstimo encontrado!");
            }

            return emprestimos;

        } catch (SQLException e) {

            MensagemHelper.erro("Erro ao listar os empréstimos, observe: " + e.getMessage());

            e.printStackTrace();
        }

        return null;
    }
}