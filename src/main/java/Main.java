import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {

        try {


            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rotman", "carlos.silva", "1234");

            if (connection != null) {
                System.out.println("Banco de Dados Conectado!");
                Statement statement = connection.createStatement();

            }else{
                System.out.println("Conexão Com o Banco Falhou");


            }
        }catch (SQLException e){
            e.printStackTrace();
        }




    }
}
