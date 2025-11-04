package pablo.tzeliks;

import pablo.tzeliks.infraestructure.LivroRepository;
import pablo.tzeliks.service.LivroService;
import pablo.tzeliks.view.BibliotecaView;

public class Main {
    public static void main(String[] args) {

        // Injeção de Dependências
        LivroRepository livroRepository = new LivroRepository();

        LivroService livroService = new LivroService(livroRepository);

        BibliotecaView bibliotecaView = new BibliotecaView(livroService);

        // Inicializa
        bibliotecaView.iniciar();
    }
}