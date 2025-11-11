package pablo.tzeliks;

import pablo.tzeliks.infraestructure.DevolucaoRepository;
import pablo.tzeliks.infraestructure.EmprestimoRepository;
import pablo.tzeliks.infraestructure.LivroRepository;
import pablo.tzeliks.service.DevolucaoService;
import pablo.tzeliks.service.EmprestimoService;
import pablo.tzeliks.service.LivroService;
import pablo.tzeliks.view.BibliotecaView;

public class Main {
    public static void main(String[] args) {

        // Injeção de Dependências
        LivroRepository livroRepository = new LivroRepository();
        EmprestimoRepository emprestimoRepository = new EmprestimoRepository();
        DevolucaoRepository devolucaoRepository = new DevolucaoRepository();

        LivroService livroService = new LivroService(livroRepository);
        EmprestimoService emprestimoService = new EmprestimoService(emprestimoRepository);
        DevolucaoService devolucaoService = new DevolucaoService(devolucaoRepository);

        BibliotecaView bibliotecaView = new BibliotecaView(livroService, emprestimoService, devolucaoService);

        // Inicializa
        bibliotecaView.iniciar();
    }
}