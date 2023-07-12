package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConnection(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbzupfood",
                    "postgres", "admin123");

            if (connection != null) System.out.println("Banco conectado");
            else System.out.println("Banco não fez conexão");

            return connection;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
