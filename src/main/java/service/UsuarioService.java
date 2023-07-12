package service;

import connection.Conexao;

import java.sql.Connection;
import java.sql.SQLException;

public class UsuarioService {

    Connection connection = Conexao.getConnection();


    public void listandoTodosUsuario(){

        try {
            if (connection != null) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }




    }



}
