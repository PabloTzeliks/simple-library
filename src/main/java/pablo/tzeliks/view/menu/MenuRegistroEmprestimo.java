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

public class MenuRegistroEmprestimo {

    public static void executarEmprestimo(Scanner sc, LivroService livroService, EmprestimoService emprestimoService) {

        MenuHelper.menuEmprestimoLivro();

        List<Livro> livros = livroService.listarLivros();
        List<Integer> livrosIds = new ArrayList<>();
        Livro livroEscolhido;
        LocalDate dataDevolucao;

        // Etapa 1 - Escolher o Livro
        MenuHelper.menuListagemLivros();

        for(Livro livro : livros) {

            System.out.println(livro.toString());
            MenuHelper.espacador();

            livrosIds.add(livro.getId());
        }

        while(true) {

            int livroEscolhidoId = InputHelper.lerInt(sc, "\nEscolha o livro desejado (Digite o ID): ");

            if (livrosIds.contains(livroEscolhidoId)) {

                MensagemHelper.sucesso("Livro encontrado.");

                livroEscolhido = livros.get(livrosIds.indexOf(livroEscolhidoId));
                break;
            }

            MensagemHelper.info("Nenhum livro encontrado com o ID: " + livroEscolhidoId + ", tente novamente.");
        }

        MenuHelper.espacador();
        System.out.println(livroEscolhido.toString());;
        MenuHelper.espacador();

        // Etapa 2 - Definir data de devolução

        MensagemHelper.subtitulo("Escolha da Data de Devolução");

        dataDevolucao = InputHelper.lerLocalDate(sc, "Data de Devolução: ");

        // Etapa 3 - Efetuar empréstimo

        MensagemHelper.subtitulo("Efetuar Empréstimo");

        while(true) {

            String escolhaUsuario = InputHelper.lerString(sc, "Deseja efetuar o empréstimo? Sim: 'S' ou Não: 'N'" +
                    "\nEfetue sua escolha: ");

            if(escolhaUsuario.equals("S")) {

                Emprestimo emprestimo = new Emprestimo(0, livroEscolhido, LocalDate.now(), dataDevolucao);

                emprestimoService.emprestarLivro(emprestimo);
                livroService.alterarDisponibilidade(livroEscolhido);

                MensagemHelper.sucesso("Empréstimo registrado com Sucesso!");

                break;
            } else if (escolhaUsuario.equals("N")) {

                MensagemHelper.info("Empréstimo em andamento cancelado.");
                break;
            }
        }

    }
}