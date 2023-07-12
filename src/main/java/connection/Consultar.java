package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultar {
    String sql = "select * from usuario";

    public void consultarDados(){
        Connection connection = Conexao.getConnection();
        try {
            if (connection != null){
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){ // acessa os valores da coluna
                    System.out.println("id: " + resultSet.getInt ("id_usuario") +
                            ", nome: " + resultSet.getString("nome")); // mostra os valores

                }

            }

        }catch (SQLException e){
            System.out.println("não foi possivel mostrar os dados");
            e.printStackTrace();


        }

    }

}
