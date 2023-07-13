import connection.Conexao;
import service.UsuarioService;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {


        Conexao.getConnection();

        UsuarioService service = new UsuarioService();

        service.adicionaUsuario("Postgres");
        service.atualizaUsuario(2,"MsAcess");
        service.consultaNomeUsuario();
        service.consultaUsuarios();
        service.deleteUsuario(12);

    }
}
