package pablo.tzeliks.infraestructure;

import pablo.tzeliks.infraestructure.Conn.Conexao;
import pablo.tzeliks.model.Emprestimo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DevolucaoRepository {

    public void updateLivroStatus(Emprestimo emprestimo) throws SQLException {

        String sqlUpdateDisponibilidade = """
                UPDATE livros SET disponivel = ? WHERE id = ?;
                """;

        try (Connection conn = Conexao.conexao();
             PreparedStatement stmt = conn.prepareStatement(sqlUpdateDisponibilidade)) {

            stmt.setBoolean(1, true);
            stmt.setInt(2, emprestimo.getLivro().getId());

            stmt.executeUpdate();
        }
    }
}