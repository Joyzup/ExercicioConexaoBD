package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultarColuna {
    public void consultarColunaDeNome(){
        String sql = "SELECT nome FROM usuario";
        Connection connection = Conexao.getConnection();
        try {
            if (connection != null){
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){ // acessa os valores da coluna nome
                    System.out.println("nome: " + resultSet.getString ("nome"));  // mostra somente a coluna nome

                }

            }

        }catch (SQLException e){
            System.out.println("não foi possivel mostrar os dados");
            e.printStackTrace();


        }
    }
}
