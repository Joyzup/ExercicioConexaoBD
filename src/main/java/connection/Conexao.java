package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConnection(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/zupfood",
                    "postgres", "123456");
            if (connection != null){
                System.out.println("Conexão com o banco de dados feita com sucesso!");
            } else {
                System.out.println("Conexão com o bando de dados falhou!");
            }
            return connection;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
