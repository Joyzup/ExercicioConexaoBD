import connection.Conexao;
import service.ConexaoService;
/*
Exercício
1 - Faça as seguintes interações com o banco:
Consulte todos os dados da tabela;
Insira dados na tabela;
Atualize dados na tabela;
Delete dados na tabela;
Consulte somente a coluna nomes da tabela;

 */
public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {

        //ConexaoService.criarTabelaUsuario();
        //ConexaoService.insereDados("Ana Paula");
        //ConexaoService.alterarTabela();
        //ConexaoService.insereDadosEmUsuarioExistente("Ana Paula", "00000000001", 20);
        //ConexaoService.insereDadosTotais("Carlos", "00000000002", 43);
        //ConexaoService.insereDadosTotais("Felipe", "00000000002", 24);
        //ConexaoService.insereDadosTotais("Alexandra", "00000000004", 27);
        //ConexaoService.insereDadosTotais("Carolina", "00000000005", 33);
        //ConexaoService.insereDadosTotais("Letícia", "00000000006", 13);
        //ConexaoService.atualizaDados("Felipe","00000000003");
        //ConexaoService.deletaUsuario0("00000000001");
        ConexaoService.consultaTodosOsDados();
        System.out.println("--------------------");
        ConexaoService.consultaNomes();

    }
}
