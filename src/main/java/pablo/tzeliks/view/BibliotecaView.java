package pablo.tzeliks.view;

import pablo.tzeliks.service.DevolucaoService;
import pablo.tzeliks.service.EmprestimoService;
import pablo.tzeliks.service.LivroService;
import pablo.tzeliks.view.helper.InputHelper;
import pablo.tzeliks.view.helper.MenuHelper;
import pablo.tzeliks.view.menu.MenuCadastroLivro;
import pablo.tzeliks.view.menu.MenuDevolucaoLivro;
import pablo.tzeliks.view.menu.MenuRegistroEmprestimo;

import java.util.Scanner;

public class BibliotecaView {

    private EmprestimoService emprestimoService;
    private LivroService livroService;
    private DevolucaoService devolucaoService;
    private Scanner sc;

    public BibliotecaView(LivroService livroService, EmprestimoService emprestimoService, DevolucaoService devolucaoService) {
        this.livroService = livroService;
        this.emprestimoService = emprestimoService;
        this.devolucaoService = devolucaoService;
        this.sc = new Scanner(System.in);
    }

    public void iniciar() {
        String opcao;

        do {

            MenuHelper.menuPrincipal();
            opcao = InputHelper.lerString(sc, "\nDigite a opção desejada: ");

            switch (opcao) {

                case "1":
                    MenuCadastroLivro.executarCadastro(sc, livroService);
                    break;
                case "2":
                    MenuRegistroEmprestimo.executarEmprestimo(sc, livroService, emprestimoService);
                    break;
                case "3":
                    MenuDevolucaoLivro.executarDevolucao(sc, emprestimoService, devolucaoService);
                    break;
                case "0":
                    System.out.println("Fim! Encerrando programa ...");
                    return;
            }

        } while (true);
    }
}