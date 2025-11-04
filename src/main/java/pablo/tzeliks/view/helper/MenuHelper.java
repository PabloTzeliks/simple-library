package pablo.tzeliks.view.helper;

public class MenuHelper {

    public static void espacador() {

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    public static void menuPrincipal() {

        espacador();

        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("\n1- Registrar Livro");
        System.out.println("2- Registrar um empréstimo");
        System.out.println("3- Registrar uma Devolução");
        System.out.println("4- Listar Livros");
        System.out.println("5- Listar Emprestimos");
    }

    public static void menuCadastroLivro() {

        espacador();

        System.out.println("=== MENU CADASTRO LIVRO ===");
        System.out.println();
    }
}