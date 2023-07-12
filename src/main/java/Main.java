import connection.Conexao;
import service.ConsultaService;

import static connection.Conexao.getConnection;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {

        ConsultaService consultaService = new ConsultaService();

        consultaService.consultarTodosDadosTabela();

    }
}
