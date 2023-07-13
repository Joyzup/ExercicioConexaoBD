package controller;

import connection.Conexao;
import model.DadosTabela;
import model.ModificarTabela;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {
    Scanner input;
    DadosTabela dadosTabela;
    ModificarTabela modificarTabela;
    Statement statement;

    public Menu() {
        this.input = new Scanner(System.in);
        this.dadosTabela = new DadosTabela();
        this.modificarTabela = new ModificarTabela();
    }

    public void executar(){
        String opcao, nomeAntigo, novoNome;
        try {
            statement = Conexao.getConnection().createStatement();
        } catch (SQLException e){
            e.printStackTrace();
        }
        do {
            mostraMenu();
            opcao = input.nextLine();
            switch (opcao){
                case "1":
                    dadosTabela.mostrarTodosOsDados(statement);
                    pause();
                    break;
                case "2":
                    dadosTabela.mostrarNomes(statement);
                    pause();
                    break;
                case "3":
                    System.out.println("Digite o nome do novo usuário:");
                    novoNome = input.nextLine();
                    modificarTabela.adicionarUsuario(statement, novoNome);
                    break;
                case "4":
                    System.out.println("Digite o nome do usuário que está salvo no momento:");
                    nomeAntigo = input.nextLine();
                    System.out.println("Digite o novo nome do usuário:");
                    novoNome = input.nextLine();
                    modificarTabela.atualizarNomeUsuario(statement, nomeAntigo, novoNome);
                    break;
                case "5":
                    System.out.println("Digite o nome do usuário que deseja deletar:");
                    novoNome = input.nextLine();
                    modificarTabela.deletarUsuario(statement, novoNome);
                    break;
                case "0":
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (!opcao.equals("0"));
    }

    private void mostraMenu(){
        System.out.println("1 - Ver todos os dados registrados");
        System.out.println("2 - Ver nomes dos usuários registrados");
        System.out.println("3 - Adicionar novo usuário");
        System.out.println("4 - Modificar usuário");
        System.out.println("5 - Deletar usuário");
        System.out.println("0 - Sair");
    }

    private void pause(){
        System.out.println("Aperte Enter para continuar");
        input.nextLine();
    }
}
