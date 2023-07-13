package service;

import connection.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static connection.Conexao.getConnection;

public class UsuarioService {

    private Statement statement;

    public UsuarioService(){
        try{
            statement = getConnection().createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //métodos de consulta
    public void consultaTodosDadosDaTabela(){
        String sql = "SELECT * from usuarios";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("id: " + resultSet.getInt("id_usuario") +
                        ", nome: " + resultSet.getString("nome"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void consultaColunaEspecifica(String column){
        String sql = "SELECT " + column + " from usuarios";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(column + ": " + resultSet.getString(column));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //método para inserir dados
    public void inserirDadosNaTabela(String nome){
        String sql = "INSERT INTO usuarios (nome) values ('" + nome + "')";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado inserido com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Outra forma de inserção utilizando o preparedStatement
//    public void inserirDadosNaTabela(String nome){
//            String sql = "INSERT INTO usuarios (nome) values (?)";
//            PreparedStatement preparedStatement = null;
//            try{
//                preparedStatement = Conexao.getConnection().prepareStatement(sql);
//
//                preparedStatement.setString(1, nome);
//                preparedStatement.executeUpdate();
//                System.out.println("Dado inserido com sucesso!");
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//    }


    //método para atualizar dados na tabela
    public void atualizaDadosNaTabela(Long id, String nome){
        String sql = "UPDATE usuarios set nome = '" + nome + "' where id_usuario = '" + id + "'";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado atualizado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //método para deletar dados na tabela
    public void deletaDadosNaTabela(Long id){
        String sql = "DELETE from usuarios where id_usuario = '" + id + "'";
        try{
            statement.executeUpdate(sql);
            System.out.println("Dado deletado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
