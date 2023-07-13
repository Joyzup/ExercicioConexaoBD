package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DadosTabela {
    public void mostrarTodosOsDados(Statement statement){
        String sql = "select * from pessoas";
        boolean primeiroLaco = true;
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (primeiroLaco){
                    System.out.printf("%-10s %s\n", "ID", "NOME");
                    primeiroLaco = false;
                }
                System.out.printf("%-10s %s\n", resultSet.getInt("id_pessoa"), resultSet.getString("nome"));
            }
            if (primeiroLaco){
                System.out.println("Não há usuários registrados");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void mostrarNomes(Statement statement){
        String sql = "select nome from pessoas";
        boolean primeiroLaco = true;
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                if (primeiroLaco){
                    System.out.println("NOME");
                    primeiroLaco = false;
                }
                System.out.println(resultSet.getString("nome"));
            }
            if (primeiroLaco){
                System.out.println("Não há usuários registrados");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
