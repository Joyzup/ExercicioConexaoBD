package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Atualizar {
    public void atualizarDados(String nome , String alteracao){
        String sql = "UPDATE usuario set nome='" + alteracao +"'" +
                "WHERE nome='" + nome + "'";
        Connection connection = Conexao.getConnection();
        try {
            if (connection != null){
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
                System.out.println("Nome alterado com sucesso!");

            }


        }catch (SQLException e){
            System.out.println("Não foi possivel alterar");
            e.printStackTrace();

        }

    }
}
