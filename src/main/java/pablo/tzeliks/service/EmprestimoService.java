package pablo.tzeliks.service;

import pablo.tzeliks.infraestructure.LivroRepository;
import pablo.tzeliks.model.Emprestimo;
import pablo.tzeliks.model.Livro;
import pablo.tzeliks.view.helper.MensagemHelper;

public class EmprestimoService {

    private LivroRepository repository;

    public EmprestimoService(LivroRepository repository) {
        this.repository = repository;
    }

    public void emprestarLivro(Emprestimo emprestimo) {

        try {
            repository.save(emprestimo);
        } catch (Exception e) {

            MensagemHelper.erro("Erro ao registrar empréstimo do Livro, observe: " + e.getMessage());

            e.printStackTrace();
        }
    }
}
