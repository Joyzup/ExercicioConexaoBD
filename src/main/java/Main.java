import connection.Conexao;
import org.postgresql.jdbc.PgConnection;
import service.UsuarioService;

import java.sql.Connection;
import java.sql.Statement;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {
UsuarioService usuarioService = new UsuarioService();
usuarioService.inserirDados();

usuarioService.listarUsuariosCadastrados();
usuarioService.deletarDados();
usuarioService.listarUsuariosCadastrados();
   usuarioService.listarUsuariosCadastrados();
    }


}

