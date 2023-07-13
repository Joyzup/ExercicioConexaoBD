import connection.Conexao;
import service.UsuarioService;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class Main {


    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) throws SQLException {

        //UsuarioService.insereDadosNoBanco();
        //UsuarioService.consultaTodosDadosNoBanco();
        //UsuarioService.alteraDadosNoBanco();
        //UsuarioService.deletarDadosNoBanco();
          UsuarioService.consultaPorNome();



    }

}

