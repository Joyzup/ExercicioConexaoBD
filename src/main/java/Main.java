import connection.*;
import model.Usuario;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Consultar consultar = new Consultar();


        // Consulte todos os dados da tabela
        consultar.consultarDados();

        //Inserir dados na Tabela
        Usuario usuario = new Usuario();
        usuario.setNome("Yas");
        Inserir inserir = new Inserir();
        inserir.inserirDados(usuario.getNome());
        inserir.inserirDados("Diana");
        consultar.consultarDados();

        //Atualizar dados
        Atualizar atualizar = new Atualizar();
        atualizar.atualizarDados("4", "Elias");
        consultar.consultarDados();

        // Excluir
        Excluir excluir = new Excluir();
        excluir.excluirDados(6);
        consultar.consultarDados();

        //consultar coluna nome

        ConsultarColuna consultarColuna = new ConsultarColuna();
        consultarColuna.consultarColunaDeNome();


    }


}

