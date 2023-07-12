import connection.Conexao;
import service.Service;

import java.sql.Connection;
import java.sql.Statement;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {
        Service servico = new Service();

//        servico.inserirNovosDados("Jaime Lannister", 31);
//        servico.inserirNovosDados("Ned Stark", 47);
//        servico.exibirDadosDosUsuarios();
//        servico.deletarDados("Jaime Lannister");
//        servico.atualizarDadosDoUsuario("Sansa Stark", 15);
//        servico.inserirNovosDados("Bran Stark", 11);

        servico.exibirNomesDosUsuarios();
        servico.exibirDadosDosUsuarios();




    }
}
