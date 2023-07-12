package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Inserir {


    public void inserirDados(String nome ){
        String sql = "INSERT INTO usuario (nome) VALUES ('" + nome +"')";
        Connection connection = Conexao.getConnection();
        try {
            if (connection != null){
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
                System.out.println("Nome inserido com sucesso!");

            }


        }catch (SQLException e){
            System.out.println("Não foi possivel inserir");
            e.printStackTrace();

        }
    }


}
