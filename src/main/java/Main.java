import connection.Conexao;
import services.Operacoes;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Operacoes operacoes = new Operacoes();
        Connection conn = conexao.conectar_Banco_Dados("teste","postgres","admin");

//        operacoes.criarTabela(conn,"usuarios");
//
//        operacoes.inserirDados(conn,"usuarios","Muryllo");
//        operacoes.inserirDados(conn,"usuarios","Mattheus");
//        operacoes.inserirDados(conn,"usuarios","Michell");
//        operacoes.inserirDados(conn,"usuarios","Marianne");
//
//        operacoes.consultarDados(conn,"usuarios");
//        operacoes.consultarNomes(conn,"usuarios");
//
//        operacoes.atualizarDadoPorNome(conn,"usuarios","Muryllo","Mu");
//        operacoes.consultarDados(conn,"usuarios");

//        operacoes.deletarDadoPorId(conn,"usuarios",1L);
//        operacoes.consultarDados(conn,"usuarios");





    }
}
