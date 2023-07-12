package model;

import java.sql.*;

class InsertExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/nome_do_banco_de_dados";
        String user = "seu_usuario";
        String password = "sua_senha";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            String sql = "INSERT INTO nome_da_tabela (coluna1, coluna2, coluna3) VALUES ('valor1', 'valor2', 'valor3')";
            statement.executeUpdate(sql);

            System.out.println("Dados inseridos com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
