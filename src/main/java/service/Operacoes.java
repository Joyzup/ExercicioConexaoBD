package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operacoes {

    private Statement statement;
    private ResultSet resultSet;

    public Operacoes(Connection connection) {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultaTodosOsDados(){
        String sql = "SELECT * FROM usuarios";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("ID usuário: " + resultSet.getInt("id_usuario") +
                        " / Nome: " + resultSet.getString("nome"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void inserirDados(String nome) {
        String sql = "INSERT INTO usuarios (nome) VALUES ('" + nome + "')";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarDados(int id, String novoNome) {
        String sql = "UPDATE usuarios SET nome = '" + novoNome + "' WHERE id_usuario = " + id;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarDados(int id) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = " + id;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultaNomes() {
        String sql = "SELECT nome FROM usuarios";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                System.out.println("Nome: " + nome);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
