package pablo.tzeliks.infraestructure.Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/sql_db?useSSL=false&serverTimezone=UTC";
    private static final String User = "root";
    private static final String Passwd = "passwd";

    public static Connection conexao() throws SQLException {
        return DriverManager.getConnection(URL, User, Passwd);
    }
}