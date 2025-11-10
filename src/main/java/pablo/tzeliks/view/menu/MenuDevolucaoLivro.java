package pablo.tzeliks.view.menu;

import pablo.tzeliks.model.Emprestimo;
import pablo.tzeliks.model.Livro;
import pablo.tzeliks.service.EmprestimoService;
import pablo.tzeliks.service.LivroService;
import pablo.tzeliks.view.helper.InputHelper;
import pablo.tzeliks.view.helper.MensagemHelper;
import pablo.tzeliks.view.helper.MenuHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuDevolucaoLivro {

    public static void executarDevolucao(Scanner sc, LivroService livroService, EmprestimoService emprestimoService) {

        MenuHelper.menuDevolucaoLivro();

        List<Emprestimo> emprestimos = emprestimoService.listarEmprestimos();
        List<Integer> emprestimosIds = new ArrayList<>();
        Emprestimo emprestimoEscolhido;
        LocalDate dataAtual = LocalDate.now();

        // Etapa 1 - Escolher o Livro
        MenuHelper.menuListagemLivros();

        for (Emprestimo emprestimo : emprestimos) {

            System.out.println(emprestimo.toString());
            MenuHelper.espacador();

            emprestimosIds.add(emprestimo.getId());
        }

        while(true) {

            int emprestimoEscolhidoId = InputHelper.lerInt(sc, "\nEscolha o empréstimo desejado (Digite o ID): ");

            if (emprestimosIds.contains(emprestimoEscolhidoId)) {

                MensagemHelper.sucesso("Livro encontrado.");

                emprestimoEscolhido = emprestimos.get(emprestimosIds.indexOf(emprestimoEscolhidoId));
                break;
            }

            MensagemHelper.info("Nenhum livro encontrado com o ID: " + emprestimoEscolhidoId + ", tente novamente.");
        }

        MenuHelper.espacador();
        System.out.println(emprestimoEscolhido.toString());;
        MenuHelper.espacador();

        // Etapa 2 - Validar data de devolução

        if (!dataAtual.isEqual(emprestimoEscolhido.getDataDevolucao())) {

            MensagemHelper.erro("");
        }

    }
}