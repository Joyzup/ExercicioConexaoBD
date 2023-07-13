import model.Usuario;
import service.ExecutarService;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {

        ExecutarService executarService = new ExecutarService();
        executarService.consultarBD();

        executarService.inserirDados();
        executarService.alterarDados();

        executarService.inserirDados();
        executarService.consultarNome();

//        Usuario usuario = new Usuario();
//        usuario.getNome();

        executarService.consultarBD();

        executarService.deletarDados();

    }
}