package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection conn=null;

    public Connection conectar_Banco_Dados(String nome_banco,String usuario,String senha){
            try{
                conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"
                      +nome_banco,usuario,senha);
                System.out.println("Conexão feita com sucesso! ");
            }catch(SQLException e){
                System.out.println("Erro, não foi possivel fazer a conexão com o banco de dados! ");
            }
            return conn;
    }

}
