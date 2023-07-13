package connection;

import java.sql.*;

public class Conexao {
    //Conexão com o banco de dados

    public static Connection getConnection() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testebancodedados",
                    "postgres", "Postgres@1982");

            if (connection != null) {
                System.out.println("|--------------------------------------------------|");
                System.out.println("| Conexão ao Banco de Dados realizada com sucesso! |");
                System.out.println("|--------------------------------------------------|");
                Statement statement = connection.createStatement();

            } else {
                System.out.println("|------------------------------------------|");
                System.out.println("| Conexão ao banco de dados não realizada! |");
                System.out.println("|------------------------------------------|");
            }
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
