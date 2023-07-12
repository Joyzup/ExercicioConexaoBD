package service;

import connection.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryService {
  public void consultaTodosDadosBanco() {
    String sql = "SELECT * FROM usuarios";
    try {
      Statement statement = Conexao.getConnection().createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        System.out.println("ID: " + rs.getInt("id_usuario") +
            " Nome: " + rs.getString("nome"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void consultaNomesBanco() {
    String sql = "SELECT nome FROM usuarios";
    try {
      Statement statement = Conexao.getConnection().createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        System.out.println(" Nome: " + rs.getString("nome"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void insereDadosBanco(String nome) {
    String sql = "INSERT INTO usuarios (nome) values ('" + nome + "')";
    try {
      Statement statement = Conexao.getConnection().createStatement();
      statement.executeUpdate(sql);
      System.out.println("Adicionado com sucesso!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void atualizaDadosBanco(String nome, String novoNome) {
    nome = "'" + nome + "'";
    novoNome = "'" + novoNome + "'";
    String sql = "UPDATE usuarios SET nome = " + novoNome + " where nome = " + nome;
    try {
      Statement statement = Conexao.getConnection().createStatement();
      statement.executeUpdate(sql);
      System.out.println("Atualizado com sucesso!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deletaDadosBanco(int id) {
    String sql = "DELETE FROM usuarios where id_usuario = " + id;
    try {
      Statement statement = Conexao.getConnection().createStatement();
      statement.executeUpdate(sql);
      System.out.println("Deletado com sucesso!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
