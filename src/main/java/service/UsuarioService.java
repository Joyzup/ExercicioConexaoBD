package service;

import connection.Conexao;
import java.sql.*;

public class UsuarioService {

    Connection connection = Conexao.getConnection();

    public void listandoTodosUsuario(){

        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM usuarios";
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    Long idUsuario = resultSet.getLong("id_usuario");
                    String nome = resultSet.getString("nome");
                    String cpf = resultSet.getString("cpf");
                    String email = resultSet.getString("email");
                    String telefone = resultSet.getString("telefone");

                    System.out.println("-----------------------");
                    System.out.println("ID: " + idUsuario);
                    System.out.println("Nome: " + nome);
                    System.out.println("CPF: " + cpf);
                    System.out.println("Email: " + email);
                    System.out.println("Telefone: " + telefone);
                    System.out.println("-----------------------");
                }

                resultSet.close();
                statement.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void buscandoUsuarioPeloCpf(String cpf){

        try {
            if (connection != null) {
                String sql = "SELECT * FROM usuarios WHERE cpf = ?";
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1, cpf);

                ResultSet resultSet = statement.executeQuery();

                if(resultSet.next()){
                    Long idUsuario = resultSet.getLong("id_usuario");
                    String nome = resultSet.getString("nome");
                    String cpfCliente= resultSet.getString("cpf");
                    String email = resultSet.getString("email");
                    String telefone = resultSet.getString("telefone");

                    System.out.println("-----------------------");
                    System.out.println("ID: " + idUsuario);
                    System.out.println("Nome: " + nome);
                    System.out.println("CPF: " + cpfCliente);
                    System.out.println("Email: " + email);
                    System.out.println("Telefone: " + telefone);
                    System.out.println("-----------------------");
                } else {
                    System.out.println("Não existe nenhum cadastro com este cpf");
                }

                resultSet.close();
                statement.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void adicionarUsuario(String nome, String cpf, String email, String telefone) {
        try {
            if (connection != null) {
                String sql = "INSERT INTO usuarios (nome, cpf, email, telefone) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1, nome);
                statement.setString(2, cpf);
                statement.setString(3, email);
                statement.setString(4, telefone);

                int contaQuantasLinhasAdiconou = statement.executeUpdate();

                if (contaQuantasLinhasAdiconou > 0) {
                    System.out.println(" ==== Usuário adicionado com sucesso! ====");
                } else {
                    System.out.println("==== Falha ao adicionar o usuário ====");
                }

                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerUsuarioPorCPF(String cpfRemover) {
        try {
            if (connection != null) {
                String sql = "DELETE FROM usuarios WHERE cpf = ?";
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1, cpfRemover);

                int contaQuantasLinhasRemoveu = statement.executeUpdate();

                if (contaQuantasLinhasRemoveu > 0) {
                    System.out.println("==== Cadastro removido com sucesso! ====");
                } else {
                    System.out.println("==== Nenhum cadastro encontrado com o CPF informado. ====");
                }

                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterarDadosUsuarioPorCPF(String cpf, String novoEmail, String novoTelefone, String novoNome) {
        try {
            if (connection != null) {
                String sql = "UPDATE usuarios SET email = ?, telefone = ?, nome = ? WHERE cpf = ?";
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1, novoEmail);
                statement.setString(2, novoTelefone);
                statement.setString(3, novoNome);
                statement.setString(4, cpf);

                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("==== Dado alterado com sucesso! ====");
                } else {
                    System.out.println("==== Nenhum dado encontrado com o CPF informado. ====");
                }

                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
