package pablo.tzeliks.view.menu;

import pablo.tzeliks.model.Emprestimo;
import pablo.tzeliks.service.EmprestimoService;
import pablo.tzeliks.view.helper.MenuHelper;

import java.util.List;

public class MenuListagemEmprestimos {

    public static void executarListagem(EmprestimoService emprestimoService) {

        List<Emprestimo> listaEmprestimos = emprestimoService.listarEmprestimos();

        MenuHelper.menuListagemEmprestimos();

        for (Emprestimo emprestimo : listaEmprestimos) {

            MenuHelper.espacador();

            System.out.println(emprestimo.toString());
        }
    }
}
