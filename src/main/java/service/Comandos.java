package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static connection.Conexao.getConnection;

public class Comandos {

    private Statement statement;

        public void Service(){
            try{
                statement = getConnection().createStatement();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        public void consultarDados(){
            Service();
            String comandoConsultarDados = "select * from usuarios";
            try {
                ResultSet resultSet = statement.executeQuery(comandoConsultarDados);
                while(resultSet.next()) {
                    System.out.println("id: " + resultSet.getInt("id_usuario") + " | nome: " + resultSet.getString("nome"));
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        public void inserirDados(String nome){
            Service();
            String comandoInserirDados = "insert into usuarios (nome) values ('" + nome + "')";
            try {
                statement.executeUpdate(comandoInserirDados);
                System.out.println("Nome adicionado com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void atualizarDados(int id, String nome){
            Service();
            String comandoAtualizarDados = "update usuarios set nome ='" + nome + "' where id_usuario = '" + id + "'";
            try {
                statement.executeUpdate(comandoAtualizarDados);
                System.out.println("Nome atualizado com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void removerDados(int id){
            Service();
            String comandoRemoverDados = "delete from usuarios where id_usuario = '" + id + "'";
            try {
                statement.executeUpdate(comandoRemoverDados);
                System.out.println("Nome removido com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void consultarApenasNomes(){
            Service();
            String comandoConsultarNomes = "select nome from usuarios";
            try {
                ResultSet resultSet = statement.executeQuery(comandoConsultarNomes);
                while (resultSet.next()){
                    System.out.println("- " + resultSet.getString("nome"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void fecharConexao(){
            Service();
            try {
                getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
