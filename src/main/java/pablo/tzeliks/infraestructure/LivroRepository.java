package pablo.tzeliks.infraestructure;

import pablo.tzeliks.infraestructure.Conn.Conexao;
import pablo.tzeliks.model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroRepository {

    public void save(Livro livro) throws SQLException {

        String queryInsereLivro = """
                INSERT INTO livros (titulo, autor, ano, disponivel) VALUES (?, ?, ?, ?);
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

    public List<Livro> list() throws SQLException {

        List<Livro> livros = new ArrayList<>();

        String sqlListagemLivros = """
                SELECT id, titulo, autor, ano, disponivel FROM livros;
                """;

        try (Connection conn = Conexao.conexao();
             PreparedStatement stmt = conn.prepareStatement(sqlListagemLivros)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Livro livro = new Livro(rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"), rs.getInt("ano"), rs.getBoolean("disponivel"));

                livros.add(livro);
            }

            return livros;
        }
    }

    public void updateDisponibilidade(Livro livro) throws SQLException {

        String sqlUpdateStatus = """
                UPDATE livros SET disponivel = ? WHERE id = ?;
                """;

        try (Connection conn = Conexao.conexao();
             PreparedStatement stmt = conn.prepareStatement(sqlUpdateStatus)) {

            stmt.setBoolean(1, livro.isDisponivel());
            stmt.setInt(2, livro.getId());

            stmt.executeUpdate();
        }
    }
}
