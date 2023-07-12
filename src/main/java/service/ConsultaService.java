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

    public void inserirDados(String nome){
        String sql = "INSERT INTO usuarios (nome) VALUES '" + nome + "' ";
        try {
            statement.executeUpdate(sql);
            System.out.println("Usuário " + nome + " adicionado com sucesso!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
