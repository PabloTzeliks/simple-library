package pablo.tzeliks.view.menu;

import pablo.tzeliks.model.Livro;
import pablo.tzeliks.service.LivroService;
import pablo.tzeliks.view.helper.MenuHelper;

import java.util.List;
import java.util.Scanner;

public class MenuListagemLivros {

    public static void executarListagem(LivroService service) {

        List<Livro> livros = service.listarLivros();

        MenuHelper.menuListagemLivros();

        for(Livro livro : livros) {

            MenuHelper.espacador();

            System.out.println(livro.toString());;
        }
    }
}