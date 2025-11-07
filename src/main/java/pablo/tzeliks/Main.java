package pablo.tzeliks;

import pablo.tzeliks.infraestructure.EmprestimoRepository;
import pablo.tzeliks.infraestructure.LivroRepository;
import pablo.tzeliks.service.EmprestimoService;
import pablo.tzeliks.service.LivroService;
import pablo.tzeliks.view.BibliotecaView;

public class Main {
    public static void main(String[] args) {

        // Injeção de Dependências
        LivroRepository livroRepository = new LivroRepository();
        EmprestimoRepository emprestimoRepository = new EmprestimoRepository();

        LivroService livroService = new LivroService(livroRepository);
        EmprestimoService emprestimoService = new EmprestimoService(emprestimoRepository);

        BibliotecaView bibliotecaView = new BibliotecaView(livroService, emprestimoService);

        // Inicializa
        bibliotecaView.iniciar();
    }
}