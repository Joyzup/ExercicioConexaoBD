package service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import connection.Conexao;
public class UsuarioService {


    public void consultaUsuarios(){
        String sql = "select * from usuarios";
        try{
            Statement statement = Conexao.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("id_usuario") +
                        " nome: " + resultSet.getString("nome"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void adicionaUsuario(String nome){
        String sql = "insert into usuarios(nome) values ('"+ nome+"');";
        try {
            Statement statement = Conexao.getConnection().createStatement();
            statement.executeUpdate(sql);
            System.out.println("usuario cadastrado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizaUsuario (int id, String nome){
        String sql = "UPDATE usuarios SET nome = '" + nome + "' WHERE id_usuario = '" + id + "'";

        try{
            Statement statement = Conexao.getConnection().createStatement();
            statement.executeUpdate(sql);
            System.out.println("Alteração realizada com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteUsuario(int id){
        String sql = "DELETE FROM usuarios WHERE id_usuario ='" + id + "'";
        try{
            Statement statement = Conexao.getConnection().createStatement();
            statement.executeUpdate(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void consultaNomeUsuario(){
        String sql = "SELECT nome FROM USUARIOS";
        try{
            Statement statement = Conexao.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                System.out.println("nome: " + resultSet.getString("nome"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
