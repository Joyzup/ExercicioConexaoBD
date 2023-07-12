package connection;

import java.sql.*;

class SelectExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/nome_do_banco_de_dados";
        String user = "seu_usuario";
        String password = "sua_senha";

        try (var connection = (java.sql.Connection) DriverManager.getConnection(url, user, password);
             Statement statement = ((java.sql.Connection) connection).createStatement()) {

            String sql = "SELECT nomes FROM nome_da_tabela";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String nome = resultSet.getString("nomes");
                System.out.println(nome);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
