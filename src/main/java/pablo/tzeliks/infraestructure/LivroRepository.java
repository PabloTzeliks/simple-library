package pablo.tzeliks.infraestructure;

import pablo.tzeliks.infraestructure.Conn.Conexao;
import pablo.tzeliks.model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroRepository {

    public void save(Livro livro) throws SQLException {

        String queryInsereLivro = """
                INSERT INTO Livro titulo, autor, ano, disponivel VALUES (?, ?, ?);
                """;

        try (Connection conn = Conexao.conexao();
            PreparedStatement stmt = conn.prepareStatement(queryInsereLivro)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno());
            stmt.setBoolean(4, livro.isDisponivel());

            stmt.executeUpdate();
        }
    }
}
