package service;

import connection.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static connection.Conexao.getConnection;

public class ConsultaService {
    private Statement statement;

    public ConsultaService(){
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void consultarTodosDadosTabela(){
        String sql = "SELECT * FROM usuarios" ;
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("id_usuario") + "NOME: " + resultSet.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultarPorColuna(String coluna){
        String sql = "SELECT " + coluna + "FROM usuarios";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("NOME: " + resultSet.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserirDados(String nome){
        String sql = "INSERT INTO usuarios (nome) VALUES ('" + nome + "') ";
        try {
            statement.executeUpdate(sql);
            System.out.println("Usuário " + nome + " adicionado com sucesso!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void atualizarDados(Long id, String nome){
        String sql = "UPDATE usuarios SET nome = '" + nome + "' where id_usuario = '" + id + "' ";
        try {
            statement.executeUpdate(sql);
            System.out.println("Usuário de ID " + id + " atualizado com sucesso!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletarDados(Long id){
        String sql = "DELETE FROM usuarios WHERE id_usuario = '" + id + "' ";
        try {
            statement.executeUpdate(sql);
            System.out.println("Usuário de ID " + id + " deletado com sucesso!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
