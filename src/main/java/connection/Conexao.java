package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConnection(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "1234");

            if (connection != null)
                System.out.println("Conexão realizada com sucesso!");
            else
                System.out.println("O Banco não realizou conexão");

            return connection;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
