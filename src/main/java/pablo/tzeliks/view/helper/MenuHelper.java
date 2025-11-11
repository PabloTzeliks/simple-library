package pablo.tzeliks.view.helper;

public class MenuHelper {

    public static void espacador() {

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    public static void menuPrincipal() {

        espacador();

        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("\n1- Registrar Livro");
        System.out.println("2- Registrar um Empréstimo");
        System.out.println("3- Registrar uma Devolução");
        System.out.println("4- Listar Livros");
        System.out.println("5- Listar Empréstimos");
        System.out.println("0- Sair do Sistema");
    }

    public static void menuCadastroLivro() {

        espacador();

        System.out.println("=== MENU CADASTRO LIVRO ===");
        System.out.println();
    }

    public static void menuEmprestimoLivro() {

        espacador();

        System.out.println("=== MENU EMPRÉSTIMO LIVRO ===");
        System.out.println();
    }

    public static void menuListagemLivros() {

        System.out.println("\n=== MENU LISTAGEM LIVRO ===");
    }

    public static void menuDevolucaoLivro() {

        espacador();

        System.out.println("=== MENU DEVOLUÇÃO LIVRO ===");
        System.out.println();
    }

    public static void menuListagemEmprestimos() {

        System.out.println("\n=== MENU LISTAGEM EMPRÉSTIMO ===");
    }
}