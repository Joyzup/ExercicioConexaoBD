package connection;

import java.sql.*;

public class Conexao {
         public static Connection getConnection() {
            try {
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exercicio",
                        "postgres", "1234");
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

    }


