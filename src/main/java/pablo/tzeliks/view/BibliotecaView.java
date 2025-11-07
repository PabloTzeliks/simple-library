package pablo.tzeliks.view;

import pablo.tzeliks.service.EmprestimoService;
import pablo.tzeliks.service.LivroService;
import pablo.tzeliks.view.helper.InputHelper;
import pablo.tzeliks.view.helper.MenuHelper;
import pablo.tzeliks.view.menu.MenuCadastroLivro;
import pablo.tzeliks.view.menu.MenuRegistroEmprestimo;

import java.util.Scanner;

public class BibliotecaView {

    private EmprestimoService emprestimoService;
    private LivroService livroService;
    private Scanner sc;

    public BibliotecaView(LivroService livroService, EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
        this.livroService = livroService;
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
                case "0":
                    System.out.println("Fim! Encerrando programa ...");
                    return;
            }

        } while (true);
    }
}