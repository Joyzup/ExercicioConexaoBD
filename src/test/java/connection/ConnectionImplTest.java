package connection;

public class SqlConnectionExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/nome_do_banco_de_dados";
        String user = "seu_usuario";
        String password = "sua_senha";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);

            // Utilize a conexão para executar operações no banco de dados

            System.out.println("Conexão estabelecida com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    eprintStackTrace();
                }
            }
        }
    }
}
