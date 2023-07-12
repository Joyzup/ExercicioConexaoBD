package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConnection(){
        Connection connection = null;

        try{

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/meireBank",
                    "postgres", "puc@2015");

            if (connection != null) {


            }

            return connection;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
