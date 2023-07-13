import connection.Conexao;
import service.Operacoes;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) throws SQLException {

        Conexao conexao = new Conexao();
        Connection minhaConexao = conexao.getConnection();
        Operacoes operacoes = new Operacoes(minhaConexao);

        //operacoes.inserirDados("Henrique");
        //operacoes.atualizarDados(5, "Guilherme");
        //operacoes.deletarDados(1);
        operacoes.consultaNomes();
        //operacoes.consultaTodosOsDados();
    }
}
