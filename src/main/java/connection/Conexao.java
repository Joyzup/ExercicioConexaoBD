package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

    public static Connection getConnection(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dados_usuarios",
                    "postgres", "minhasenha");
            System.out.println("Conexão com banco de dados criada com sucesso!");
            return connection;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
