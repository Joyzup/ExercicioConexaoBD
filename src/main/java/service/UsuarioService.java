package service;

import connection.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioService {

    static Connection connection = Conexao.getConnection();

    static Statement statement;

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void consultaDados(){
        String sql = "select * from usuarios";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("id: "+ resultSet.getInt("id_usuario")
                        + " nome: "+resultSet.getString("nome"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void inserirDado(String nome){
        String sql = String.format("insert into usuarios(nome) values ('%s')",nome);
        try {
            statement.executeUpdate(sql);
            System.out.println("Usuário adicionado.");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void alterarDado(String nome, Integer idUsuario){
        String sql = String.format("update usuarios set nome='%s' where id_usuario=%d",nome,idUsuario);
        try{
            statement.executeUpdate(sql);
            System.out.println("Alteração realizada com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void excluirDado(Integer idUsuario){
        String sql =String.format("delete from usuarios where id_usuario=%d",idUsuario);
        try {
            statement.executeUpdate(sql);
            System.out.println("Usuário excluído com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void consultarNomes(){
        String sql = "select nome from usuarios";

        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("nome: "+resultSet.getString("nome"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
