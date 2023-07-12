import model.Usuario;
import service.UsuarioService;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();

        // inserindo dados
        usuarioService.inserirDados("Joao");
        usuarioService.inserirDados("Joyce");
        usuarioService.inserirDados("Iris");
        usuarioService.inserirDados("Pedro");
        usuarioService.inserirDados("Muryllo");
        usuarioService.inserirDados("Nicoly");
        usuarioService.inserirDados("Rick");

        // visualizando todos os dados
        usuarioService.consultarTodosDadosTabela();

        // visualizando coluna nome
        usuarioService.consultarPorColuna("nome");

        // visualizando coluna id_usuario
        usuarioService.consultarPorColuna("id_usuario");

        // alterando dados
        usuarioService.atualizarDados(1L, "Joao Cruz");
        usuarioService.atualizarDados(3L, "Joy");

        // deletando dados
        usuarioService.deletarDados(1L);

        // visualizando alterações
        usuarioService.consultarTodosDadosTabela();
        usuarioService.consultarPorColuna("nome");




    }
}
