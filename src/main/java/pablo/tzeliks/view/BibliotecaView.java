package pablo.tzeliks.view;

import pablo.tzeliks.service.EmprestimoService;
import pablo.tzeliks.service.LivroService;
import pablo.tzeliks.view.helper.InputHelper;
import pablo.tzeliks.view.helper.MenuHelper;
import pablo.tzeliks.view.menu.MenuCadastroLivro;

import java.util.Objects;
import java.util.Scanner;

public class BibliotecaView {

    private EmprestimoService service;
    private LivroService livroService;
    private Scanner sc;

    public void BibliotecaView(EmprestimoService service, LivroService livroService) {
        this.service = service;
        this.livroService = livroService;
        this.sc = new Scanner(System.in);
    }

    public void iniciar() {
        String opcao;

        do {

            MenuHelper.menuPrincipal();
            opcao = InputHelper.lerString(sc, "Digite a opção desejada: ");

            switch (opcao) {

                case "1":
                    MenuCadastroLivro.executarCadastro(sc, livroService);
                    break;

                case "0":
                    System.out.println("Fim! Encerrando programa ...");
                    return;
            }

        } while (true);
    }
}