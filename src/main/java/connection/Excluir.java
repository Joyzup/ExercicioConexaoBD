package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Excluir {
    public void excluirDados(int id){
        String sql = "DELETE FROM usuario WHERE id_usuario='" + id +"'";
        Connection connection = Conexao.getConnection();
        try {
            if (connection != null){
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
                System.out.println("id: "+ id +"Excluido com sucesso!");

            }


        }catch (SQLException e){
            System.out.println("Não foi possivel alterar");
            e.printStackTrace();

        }
    }
}
