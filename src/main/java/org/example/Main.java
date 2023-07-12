package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        //Conexão com banco
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/zupfood",
                    "postgres", "1234");
            if(connection != null){
                System.out.println("Banco de dados conectado!");
                Statement statement = connection.createStatement();
                insereDadosNoBanco(statement);
                consultaTodosDadosNoBanco(statement);
            }else{
                System.out.println("Conexão com o banco de dados falhou!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    //Manipulação do banco

    static void insereDadosNoBanco(Statement statement){
        String sql = "insert into usuarios (nome) values ('Bruna')";
        try{
            statement.executeUpdate(sql);
            System.out.println("Inserção feita com sucesso");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    static void consultaTodosDadosNoBanco(Statement statement){
        String sql = "select * from usuarios";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("id: " + resultSet.getInt("id_usuario") + ", nome: " +
                        resultSet.getString("nome"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }



}