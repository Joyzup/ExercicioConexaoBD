package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operacoes {
    private Statement statement;
    private ResultSet rs = null;

    public void criarTabela(Connection conn, String nome_tabela) {
        try {
            String comando = "create table " + nome_tabela +
                    "(id_usuarios SERIAL,nomes varchar(200),primary key(id_usuarios));";
            statement = conn.createStatement();
            statement.executeUpdate(comando);
            System.out.println("TABELA CRIADA! ");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela, tente novamente!");
        }
    }

    public  void inserirDados(Connection conn,String tabela,String nomes){
        try {
            String comando = String.format("insert into %s(nomes) values('%s');"
                    ,tabela,nomes);
            statement = conn.createStatement();
            statement.executeUpdate(comando);
            System.out.println("Dado inserido! ");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados na tabela, tente novamente!");
        }
    }

    public  void consultarDados(Connection conn,String tabela){
        try {
            String comando = String.format("select * from %s",tabela);
            statement = conn.createStatement();
            rs=statement.executeQuery(comando);
            System.out.println("Retornando dados");
            while (rs.next()){
                System.out.println("Id " + rs.getInt("id_usuarios"));
                System.out.println("Nome: " + rs.getString("nomes"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fazer a consulta!");
        }
    }
    public  void consultarNomes(Connection conn,String tabela){
        try {
            String comando = String.format("select (nomes) from %s;",tabela);
            statement = conn.createStatement();
            rs=statement.executeQuery(comando);
            System.out.println("Retornando nomes! ");
            while (rs.next()){
                System.out.println("Nome: " + rs.getString("nomes"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fazer a consulta!");
        }
    }

    public  void atualizarDadoPorNome(Connection conn,String tabela,String nome_antigo,String nome_novo){
        try {
            String comando = String.format("update %s set nomes='%s' where nomes='%s'",
                    tabela,nome_novo,nome_antigo);
            statement = conn.createStatement();
            statement.executeUpdate(comando);
            System.out.println("Dado atualizado! ");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dados na tabela, tente novamente!");
        }
    }

    public void deletarDadoPorId(Connection conn,String tabela,Long id){
        try {
            String comando = String.format("delete from %s where id_usuarios= %s",tabela,id);
            statement = conn.createStatement();
            statement.executeUpdate(comando);
            System.out.println("Dado removido! ");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar dados na tabela, tente novamente!");
        }
    }

}
