package service;

import connection.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioService {

    static Connection connection = Conexao.getConnection();
     Statement statement = connection.createStatement();

    public UsuarioService() throws SQLException {
    }


    public static void insereDadosNoBanco() throws SQLException {
        Statement statement  = connection.createStatement();
        String sql = "insert into cruddb (nome,cpf,email) values ('Maria','986535778','maria@gmail.com')";
        try{
            statement.executeUpdate(sql);
            System.out.println("Inserção feita com sucesso");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void consultaTodosDadosNoBanco() throws SQLException {
        Statement statement  = connection.createStatement();
        String sql = "select * from cruddb";
        if (connection != null) {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("id: " + resultSet.getInt("id_usuario") + ", nome: " +
                        resultSet.getString("nome") + ", cpf: " + resultSet.getString("cpf") + ", email: " + resultSet.getString("email"));
            }

        }

    }

    public static void alteraDadosNoBanco() throws SQLException {
        Statement statement  = connection.createStatement();
        String sql = "update cruddb set nome = 'Julia', cpf = 3457235, email = 'julia@gmail.com' where id_usuario = '5'";
        try{
            statement.executeUpdate(sql);
            System.out.println("Alteraçao feita com sucesso");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void deletarDadosNoBanco() throws SQLException {
        Statement statement  = connection.createStatement();
        String sql = "delete from cruddb where id_usuario = '12'";
        try{
            statement.executeUpdate(sql);
            System.out.println("Exclusão feita com sucesso");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void consultaPorNome() throws SQLException {
        Statement statement  = connection.createStatement();
        String sql = "SELECT nome FROM cruddb";
        if (connection != null) {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("nome: " + resultSet.getString("nome"));
            }

        }

    }


}
