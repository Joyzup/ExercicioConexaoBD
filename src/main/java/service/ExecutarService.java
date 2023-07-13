package service;

import connection.Conexao;
import java.sql.*;

public class ExecutarService {
    static Connection connection = Conexao.getConnection();
    static Statement statement;

   static {
       try {
           statement = connection.createStatement();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }

    public void consultarBD(){
        String sql = "SELECT nome FROM usuarios";
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_usuario") + " - Nome: " + rs.getString("nome") + " - Idade: " + rs.getInt("idade") + " anos.");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void inserirDados(){
        String sql = "INSERT INTO usuarios (nome, idade) VALUES " + "('Gabriel Lopes', 30), " + "('João Pedro', 25)";
        try {
            statement.executeUpdate(sql);
            System.out.println("Dados inseridos com sucesso!");
            System.out.println();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        }

    public void alterarDados(){
        String sql = "UPDATE usuarios SET nome = 'João Henrique' WHERE id_usuario = 1";
        try {
            statement.executeUpdate(sql);
            System.out.println("Dados alterados com sucesso!");
            System.out.println();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deletarDados(){
        String sql = "DELETE FROM usuarios WHERE id_usuario BETWEEN 31 AND 100";
        try {
            statement.executeUpdate(sql);
            System.out.println("Dados ID entre 8 e 30 - deletados com sucesso!");
            System.out.println();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    método para consultar campo nome da tabela do BD
    public void consultarNome(){
        String sql = "SELECT nome FROM usuarios";
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
