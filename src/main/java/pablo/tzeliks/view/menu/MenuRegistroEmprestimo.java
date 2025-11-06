package pablo.tzeliks.view.menu;

import pablo.tzeliks.model.Livro;
import pablo.tzeliks.service.EmprestimoService;
import pablo.tzeliks.service.LivroService;
import pablo.tzeliks.view.helper.InputHelper;
import pablo.tzeliks.view.helper.MensagemHelper;
import pablo.tzeliks.view.helper.MenuHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuRegistroEmprestimo {

    public static void executarEmprestimo(Scanner sc, LivroService livroService, EmprestimoService emprestimoService) {

        MenuHelper.menuEmprestimoLivro();

        List<Livro> livros = livroService.listarLivros();
        List<Integer> livrosIds = new ArrayList<>();
        Livro livroEscolhido;

        // Etapa 1 - Escolher o Livro
        MenuHelper.menuListagemLivros();

        for(Livro livro : livros) {

            MenuHelper.espacador();

            System.out.println(livro.toString());

            livrosIds.add(livro.getId());
        }

        while(true) {

            int livroEscolhidoId = InputHelper.lerInt(sc, "Escolha o livro desejado (Digite o ID): ");

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

        // Etapa 2 - Efetuar empréstimo
        while(true) {

            String escolhaUsuario = InputHelper.lerString(sc, "Deseja efetuar o empréstimo? Sim: 'S' ou Não: 'N'" +
                    "\nEfetue sua escolha: ");

            if(escolhaUsuario.equals("S")) {
                emprestimoService.emprestimo(livroEscolhido);


            }
        }
    }
}