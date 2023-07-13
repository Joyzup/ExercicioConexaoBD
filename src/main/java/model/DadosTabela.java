package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DadosTabela {
    public void mostrarTodosOsDados(Statement statement){
        String sql = "select * from pessoas";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("id_pessoa") + " Nome: " + resultSet.getString("nome"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void mostrarNomes(Statement statement){
        String sql = "select nome from pessoas";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("nome"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
