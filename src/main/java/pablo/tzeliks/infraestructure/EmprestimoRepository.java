package pablo.tzeliks.infraestructure;

import pablo.tzeliks.infraestructure.Conn.Conexao;
import pablo.tzeliks.model.Emprestimo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmprestimoRepository {

    public void save(Emprestimo emprestimo) throws SQLException {

        String sqlInsereEmprestimo = """
                INSERT INTO emprestimos (livro_id, data_emprestimo, data_devolucao) VALUES (?, ?, ?);
                """;

        try(Connection conn = Conexao.conexao();
            PreparedStatement stmt = conn.prepareStatement(sqlInsereEmprestimo)) {

            stmt.setInt(1, emprestimo.getLivro().getId());
            stmt.setDate(2, Date.valueOf(emprestimo.getDataEmprestimo()));
            stmt.setDate(3, Date.valueOf(emprestimo.getDataDevolucao()));

            stmt.executeUpdate();
        }
    }
}
