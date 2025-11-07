package pablo.tzeliks.infraestructure;

import pablo.tzeliks.infraestructure.Conn.Conexao;
import pablo.tzeliks.model.Emprestimo;
import pablo.tzeliks.model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Emprestimo> list() throws SQLException {

        List<Emprestimo> emprestimos = new ArrayList<>();

        String sqlListagemEmprestimos = """
                SELECT id, livro_id, data_emprestimo, data_devolucao FROM emprestimos"
                """;

        try(Connection conn = Conexao.conexao();
            PreparedStatement stmt = conn.prepareStatement(sqlListagemEmprestimos)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Emprestimo emprestimo = new Emprestimo(rs.getInt("id"), new Livro(rs.getInt("livro_id"), null, null, 0, false), rs.getDate("data_emprestimo").toLocalDate(), rs.getDate("data_devolucao").toLocalDate());

                emprestimos.add(emprestimo);
            }

            return emprestimos;
        }
    }
}
