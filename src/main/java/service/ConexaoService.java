package service;

import connection.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoService {


    // Método cria tabela usuario com as colunas id_usuario e nome
    public static void criarTabelaUsuario() {

        if (Conexao.getConnection() != null) {

            String sql = "CREATE TABLE usuario(id_usuario SERIAL PRIMARY KEY, nome VARCHAR(255))";
            try {
                Conexao.getConnection().createStatement().executeUpdate(sql);
                System.out.println("Tabela usuario criada com sucesso!");

            } catch (SQLException e) {

                e.getMessage();
                e.printStackTrace();

            }

        }

    }

    // Método insere dados na tabela

    public static void insereDados(String nome) {

        if (Conexao.getConnection() != null) {

            String sql = "INSERT INTO usuario (nome) VALUES (?)";
            PreparedStatement statement = null;
            try {
                statement = Conexao.getConnection().prepareStatement(sql);

                statement.setString(1, nome);
                statement.executeUpdate();
                System.out.println("Usuario(a) " + nome + " criado(a) com sucesso!");
            } catch (SQLException e) {

                e.getMessage();
                e.printStackTrace();

            }

        }

    }

    // Método cria mais duas colunas: idade e cpf
    public static void alterarTabela() {

        String sql = "ALTER TABLE usuario " +
                "ADD COLUMN cpf VARCHAR(11)," +
                "ADD COLUMN idade INT";
        Statement statement = null;

        try {

            statement = Conexao.getConnection().createStatement();
            statement.execute(sql);
            System.out.println("Tabela usuario alterada com sucesso!");

        } catch (SQLException e) {

            e.getMessage();
            e.printStackTrace();

        }

    }

    // Método insere cpf e idade em usuário existente

    public static void insereDadosEmUsuarioExistente(String nome, String cpf, Integer idade) {

        if (Conexao.getConnection() != null) {

            String sql = "UPDATE usuario SET cpf = ?, idade = ? WHERE nome = ?";
            PreparedStatement statement = null;
            try {
                statement = Conexao.getConnection().prepareStatement(sql);

                statement.setString(1, cpf);
                statement.setInt(2, idade);
                statement.setString(3, nome);
                statement.executeUpdate();
                System.out.println("Usuario(a) " + nome + " atualizado(a) com sucesso!");

            } catch (SQLException e) {

                e.getMessage();
                e.printStackTrace();

            }

        }

    }

    // Método insere dados para todas as colunas

    public static void insereDadosTotais(String nome, String cpf, Integer idade) {

        if (Conexao.getConnection() != null) {

            String sql = "INSERT INTO usuario (nome, cpf, idade) VALUES (?, ?, ?)";
            PreparedStatement statement = null;
            try {
                statement = Conexao.getConnection().prepareStatement(sql);

                statement.setString(1, nome);
                statement.setString(2, cpf);
                statement.setInt(3, idade);


                statement.executeUpdate();
                System.out.println("Usuario(a) " + nome + " criado(a) com sucesso!");
            } catch (SQLException e) {

                e.getMessage();
                e.printStackTrace();

            }

        }


    }

    // Atualiza o cpf do Felipe da tabela usuario

    public static void atualizaDados(String nome, String cpf) {

        if (Conexao.getConnection() != null) {

            String sql = "UPDATE usuario SET cpf = ? WHERE nome = ?";
            PreparedStatement statement = null;
            try {
                statement = Conexao.getConnection().prepareStatement(sql);

                statement.setString(1, cpf);
                statement.setString(2, nome);
                statement.executeUpdate();
                System.out.println("Usuario(a) " + nome + " atualizado(a) com sucesso!");

            } catch (SQLException e) {

                e.getMessage();
                e.printStackTrace();

            }

        }

    }

    // Método deleta usuário da tabela pelo cpf
    public static void deletaUsuario0(String cpf) {

        if (Conexao.getConnection() != null) {

            String sql = "DELETE FROM usuario WHERE cpf = ?";
            PreparedStatement statement = null;
            try {
                statement = Conexao.getConnection().prepareStatement(sql);

                statement.setString(1, cpf);
                statement.executeUpdate();
                System.out.println("Usuario(a) com cpf " + cpf + " deletado(a) com sucesso!");

            } catch (SQLException e) {

                e.getMessage();
                e.printStackTrace();

            }

        }

    }

    // Método que consulta todos os dados da tabela
    public static void consultaTodosOsDados() {

        if (Conexao.getConnection() != null) {

            String sql = "SELECT * FROM usuario";

            try {

                ResultSet resultSet = Conexao.getConnection().createStatement().executeQuery(sql);
                System.out.println("id |     cpf     | Idade |    nome               ");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id_usuario") +"    " + resultSet.getString("cpf") + "    " + resultSet.getInt("idade") + "      " + resultSet.getString("nome"));

                }

            } catch (SQLException e) {

                e.getMessage();
                e.printStackTrace();

            }

        }

    }

    // Método que consulta somente os nomes da tabela usuario

    public static void consultaNomes() {

        if (Conexao.getConnection() != null) {

            String sql = "SELECT nome FROM usuario";

            try {

                ResultSet resultSet = Conexao.getConnection().createStatement().executeQuery(sql);
                System.out.println("NOME");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("nome"));

                }

            } catch (SQLException e) {

                e.getMessage();
                e.printStackTrace();

            }

        }

    }
}
