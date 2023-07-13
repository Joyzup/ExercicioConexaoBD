package view;

import model.Usuario;
import service.UsuarioService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuView {
    private Scanner scanner;
    private UsuarioService usuarioService;

    public MenuView(){
        scanner = new Scanner(System.in);
        usuarioService = new UsuarioService();
    }

    public void iniciar(){
        int opcao;
        do {
            imprimirMenu();
            opcao = selecionarOpcao();

            switch (opcao) {
                case 1:
                    usuarioService.consultarTodosDadosTabela();
                    break;
                case 2:
                    System.out.print("Digite o nome da coluna: ");
                    String coluna = scanner.nextLine();
                    usuarioService.consultarPorColuna(coluna);
                    break;
                case 3:
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();
                    usuarioService.inserirDados(nome);
                    break;
                case 4:
                    System.out.print("Digite o ID do usuário: ");
                    Long idAtualizar = scanner.nextLong();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.print("Digite o novo nome do usuário: ");
                    String nomeAtualizado = scanner.nextLine();
                    usuarioService.atualizarDados(idAtualizar, nomeAtualizado);
                    break;
                case 5:
                    System.out.print("Digite o ID do usuário: ");
                    Long idDeletar = scanner.nextLong();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    usuarioService.deletarDados(idDeletar);
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 6);
    }

    public void imprimirMenu(){
        System.out.println("Escolha uma das seguintes opções");
        System.out.println("1 - Consultar todos os dados dos usu´rios");
        System.out.println("2 - Consultar dados dos usuários por coluna");
        System.out.println("3 - Cadastrar usuário");
        System.out.println("4 - Atualizar dados dos usuários");
        System.out.println("5 - Deletar usuário");
        System.out.println("6 - Sair");
        System.out.println("Digite aqui a opção: ");
    }

    public int selecionarOpcao(){
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
            scanner.nextLine();
        }
        return 1;
    }
}
