package Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServiceUser {
    public static void consultatodososDadosBanco(Statement statement){
        String sql = "Select * from usuarios";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_usuario") + " Nome: " +
                        resultSet.getString("nome"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            }
        }
        public static void insereDadosBanco(Statement statement, String nome){
        String sql = "insert into ususario (nome) values('" + nome + "')";
        try {
            statement.executeUpdate(sql);
            System.out.println("Inserção realizada\n");
            consultatodososDadosBanco(statement);
        }catch (SQLException e) {
        e.printStackTrace();}}
public static void atualizaDadosBD(Statement statement,String nome){
    String sql = "update usuario SET nome = '" novoNome + where id_usuario = 1";
        try{
            int usuarioUpdate = statement.executeUpdate(sql);
            System.out.println("'"+ novoNome + "'foi insirido no id ");
            consultatodososDadosBanco(statement);}catch (SQLException e){
            e.printStackTrace();}}

    public static void deletaDadosBanco(Statement statement, String nome){
        String sql = "delete from usuarios whre nome= "+ nome;
        try {
            int ususarioexcluido = statement.executeUpdate(sql);
            System.out.println(""+nome" Foi excluido");
            consultatodososDadosBanco(statement);}catch (SQLException e){e.printStackTrace();}}



    public static void consultarNomesBD(Statement statement){
        String sql = "select * from ususarios";
        try {ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("nome: "+resultSet.getString("nome"));}}
            catch (SQLException e){
            e.printStackTrace();

        }

        }

}

