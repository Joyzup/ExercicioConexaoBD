package service;

import connection.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioService {
    Connection connection = Conexao.getConnection();
public void inserirDados(){
String sql = "insert into usuario (ide_usuario, nome_usuario) values (2, 'bruna')";
try {
    Statement statement = connection.createStatement();
statement.executeUpdate(sql);
    System.out.println("dados inseridos com sucesso");
} catch (SQLException e){
    e.printStackTrace();
}
}
//duvida em relação a exclusão de dados.

public void deletarDados(){

    String sql = "DELETE FROM usuario where (ide_usuario = 2)";
    try {
        Statement statement = connection.createStatement();
statement.executeUpdate(sql);
        System.out.println("exclusão realizada com sucesso");
    } catch (SQLException e){
        e.printStackTrace();
    }
}
    public   void listarUsuariosCadastrados() {

        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                String sql = "SELECT * from usuario";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    Long idUsuario = resultSet.getLong("ide_usuario");
                    String nomeUsuario = resultSet.getString("nome_usuario");
                    System.out.println("id do usuário: " + idUsuario);
                    System.out.println("nome de usuário: " + nomeUsuario);
                }
                statement.close();
                resultSet.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public void listarUsuariosPeloNome() {
            try {
                if (connection != null) {
                    Statement statement = connection.createStatement();
                    String sql = "SELECT * FROM usuario";
                    ResultSet resultSet = statement.executeQuery(sql);
                    while (resultSet.next()) {
                        String nomeUsuario = resultSet.getString("nome_usuario");
                        System.out.println("nome de usuário: " + nomeUsuario);
                    }
                }
            } catch (SQLException e){
                e.printStackTrace();
            }


}


        



}
