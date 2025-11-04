package pablo.tzeliks.view.menu;

import pablo.tzeliks.model.Livro;
import pablo.tzeliks.service.LivroService;
import pablo.tzeliks.view.helper.InputHelper;
import pablo.tzeliks.view.helper.MensagemHelper;
import pablo.tzeliks.view.helper.MenuHelper;

import java.util.Scanner;

public class MenuCadastroLivro {

    public static void executarCadastro(Scanner sc, LivroService service) {

        MenuHelper.menuCadastroLivro();

        String tituloLivro = InputHelper.lerString(sc, "Digite o titulo do livro: ");
        String autorLivro = InputHelper.lerString(sc, "Digite o autor do livro: ");
        int anoLivro = InputHelper.lerInt(sc, "Digite o ano do livro: ");

        Livro livro = new Livro(0, tituloLivro, autorLivro, anoLivro, true);

        service.cadastrarLivro(livro);
    }
}
