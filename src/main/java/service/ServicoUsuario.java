package service;

import connection.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServicoUsuario {
    static Connection connection = Conexao.getConnection();

    static Statement statement;

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void consultarRegistros(){
        String sql = "select * from usuarios";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("id: "+
                        resultSet.getInt("id_usuario")
                        + " nome: "+resultSet.getString("nome"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void inserirRegistro(String nome){
        String sql = String.format("insert into usuarios(nome) values ('%s')",nome);
        try {
            statement.executeUpdate(sql);
            System.out.println("Inserção feita com sucesso.\n");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void alterarRegistro(String nome, Integer idUsuario){
        String sql = String.format("update usuarios set nome='%s' where id_usuario=%d",nome,idUsuario);
        try{
            statement.executeUpdate(sql);
            System.out.println("Realizada alteração\n");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void excluir(Integer idUsuario){
        String sql =String.format("delete from usuarios where id_usuario=%d",idUsuario);
        try {
            statement.executeUpdate(sql);
            System.out.println("O usuário foi excluído!\n");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void nomesCadastrados(){
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
