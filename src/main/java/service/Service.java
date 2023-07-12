package service;

import connection.Conexao;
import model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service {

    //ATRIBUTOS
    private Connection connection;
    private Usuario usuario;
    private Conexao conexao;
    private List<Usuario> listaDeUsuarios = new ArrayList<>();

    //CONSTRUCTOR
    public Service(Conexao conexao) {
        this.conexao = conexao;
    }
    public Service() {
    }

    //MÉTODOS
    public List<Usuario> exibirDadosDosUsuarios(){
        String sql = "select * from banco_usuarios";
        Long id_usuario;
        String nome;
        int idade;

        try{
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                nome = resultSet.getString("nome");
                idade = resultSet.getInt("idade");
                id_usuario =  resultSet.getLong("id_usuario");
                usuario = new Usuario(id_usuario, nome, idade);
                listaDeUsuarios.add(usuario);
                System.out.println("ID " + resultSet.getLong("id_usuario") + " | NOME: " + resultSet.getString("nome") + " | IDADE: " + resultSet.getInt("idade"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return listaDeUsuarios;
    }

    public void exibirNomesDosUsuarios(){
        String sql = "select nome from banco_usuarios";

        try{
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                System.out.println("NOME: " + resultSet.getString("nome"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void inserirNovosDados(String nome, int idade){
        String sql = "INSERT INTO banco_usuarios (nome, idade) VALUES (?, ?)";

        try{
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setInt(2, idade);
            statement.executeUpdate();
            System.out.println("NOVOS DADOS INSERIDOS COM SUCESSO!");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void deletarDados(String nome){
        String sql = "DELETE FROM banco_usuarios WHERE nome = ?";

        try{
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            statement.executeUpdate();
            System.out.println("DADOS DELETADOS COM SUCESSO!");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void atualizarDadosDoUsuario(String nome, int idade){
        String sql = "update banco_usuarios set idade = ? where nome = ?";

        try{
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idade);
            statement.setString(2, nome);
            statement.executeUpdate();
            System.out.println("DADO ATUALIZADO COM SUCESSO!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
