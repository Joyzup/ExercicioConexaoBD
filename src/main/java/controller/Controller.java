package controller;

import service.Comandos;

import java.util.Scanner;

public class Controller {

    Comandos comandos = new Comandos();

    Scanner resposta = new Scanner(System.in);

    public void sairPrograma(){
        System.out.println("");
        System.out.println("----------");
        System.out.println("Saindo...");
        System.out.println("----------");
        System.out.println("");

        comandos.fecharConexao();
    }

    public void consultarDados(){
        System.out.println("");
        System.out.println("----------");
        System.out.println("Lista completa:");
        comandos.consultarDados();
        System.out.println("----------");
        System.out.println("");
    }

    public void inserirDados(){
        System.out.println("");
        System.out.println("----------");
        System.out.println("Digite o nome que deseja inserir:");
        resposta.nextLine();
        String nome = resposta.nextLine();
        comandos.inserirDados(nome);
        System.out.println("----------");
        System.out.println("");
    }

    public void atualizarDados(){
        System.out.println("");
        System.out.println("----------");
        System.out.println("Diga qual o id do nome que deseja alterar:");
        int id = resposta.nextInt();
        System.out.println("Diga qual o novo nome que deseja:");
        resposta.nextLine();
        String nome = resposta.nextLine();
        comandos.atualizarDados(id, nome);
        System.out.println("----------");
        System.out.println("");
    }

    public void removerDados(){
        System.out.println("");
        System.out.println("----------");
        System.out.println("Digite o id do nome que deseja remover:");
        int id = resposta.nextInt();
        comandos.removerDados(id);
        System.out.println("----------");
        System.out.println("");
    }

    public void consultarSomenteNomes(){
        System.out.println("");
        System.out.println("----------");
        System.out.println("Lista só com os nomes:");
        comandos.consultarApenasNomes();
        System.out.println("----------");
        System.out.println("");
    }
}
