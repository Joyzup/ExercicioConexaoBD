package service;

import connection.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServiceUser {

    String sql;
    ResultSet resultSet;


    static Connection connection = Conexao.getConnection();

    static Statement statement;

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    public void consultaDados () {
         sql = "select * from usuarios";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("id: "+ resultSet.getInt("id_usuario") + " nome: " +
                        resultSet.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void incluirDados (String nome) {
        sql = String.format("insert into usuario(nome) values ('%s')", nome);
        try {
            statement.executeUpdate(sql);
            System.out.println("Usuário adicionado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void alterarDados (String nome, Integer idUsuario) {
        sql = String.format("update usuarios set nome= '%s' where id_usuario= %d" , nome, idUsuario);
        try {
            statement.executeUpdate(sql);
            System.out.println("Dados do usuário alterados.");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void excluirDados (Integer idUsuario) {
        sql = String.format("delete from usuarios where id_usuarios=%d" , idUsuario);
        try {
            statement.executeUpdate(sql);
            System.out.println("Usuário excluído.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultarNome () {
        sql = "select nome from usuarios";
        try {
           resultSet = statement.executeQuery(sql);
           while (resultSet.next()) {
               System.out.println("nome: " + resultSet.getString("nome"));
           }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
