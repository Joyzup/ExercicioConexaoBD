import controller.UsuarioController;
import service.UsuarioService;

import java.util.Scanner;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {

        UsuarioService usuarioService = new UsuarioService();
        UsuarioController usuarioController = new UsuarioController(usuarioService);

        int opcaoMenuPrincipal;
        do {
            System.out.println("\n============ Cadastro de Usuário ==========");
            System.out.println("1. Lista todos Usuários");
            System.out.println("2. Cadastra usuário");
            System.out.println("3. Altera Usuário");
            System.out.println("4. Busca Usuário");
            System.out.println("5. Deleta Usuário");
            System.out.println("6. Sair");
            System.out.print("Digite a opção desejada: ");
            opcaoMenuPrincipal = new Scanner(System.in).nextInt();

            switch (opcaoMenuPrincipal) {
                case 1:
                    usuarioController.listarClientesMenu();
                   break;
                case 2:
                    usuarioController.cadastrarUsuarioMenu();
                    break;
                case 3:
                    usuarioController.alteraUsuarioMenu();
                    break;
                case 4:
                    usuarioController.buscarUsuarioMenu();
                    break;
                case 5:
                    usuarioController.removerUsuarioMenu();
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoMenuPrincipal != 6);


    }
}
