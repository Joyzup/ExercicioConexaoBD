import model.Usuario;
import service.UsuarioService;

import java.util.Scanner;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {

        UsuarioService usuarioService = new UsuarioService();

        System.out.println("===========================================");
        System.out.println("Bem-vindes ao sistema de gestão do ZupFood");
        System.out.println("===========================================");

        Scanner entrada = new Scanner(System.in);
        Usuario usuario = new Usuario();
        boolean continuar = true;

        do {
            String opcaoMenu = menuExibir();
            switch (opcaoMenu){
                case "1":
                    usuarioService.consultaDados();
                    break;

                case "2":
                    System.out.println("Informe o nome do usuário a ser inserido no banco de dados:");
                    String nome = entrada.next();
                    usuario.setNome(nome);

                    usuarioService.inserirDado(usuario.getNome());
                    break;

                case "3":
                    System.out.println("Informe o id do usuário que deseja alterar o nome:");
                    Integer id = entrada.nextInt();
                    System.out.println("Informe o novo nome:");
                    String nomeAlterar = entrada.next();
                    usuario.setNome(nomeAlterar);

                    usuarioService.alterarDado(usuario.getNome(), id);
                    break;

                case "4":
                    System.out.println("Informe o id do usuário que deseja excluir:");
                    Integer idExcluir = entrada.nextInt();

                    usuarioService.excluirDado(idExcluir);
                    break;

                case "5":
                    usuarioService.consultarNomes();
                    break;

                case "6":
                    continuar = false;
                    System.out.println("Programa encerrado.");
                    break;
            }
        } while (continuar);

    }

    public static String menuExibir(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("-------------------------------------------");
        System.out.println("Qual operação deseja realizar?");
        System.out.println("(1) Consultar usuários");
        System.out.println("(2) Cadastrar usuário");
        System.out.println("(3) Atualizar dados de usuário");
        System.out.println("(4) Deletar usuário");
        System.out.println("(5) Consultar nomes");
        System.out.println("(6) Sair do sistema");
        System.out.println("-------------------------------------------");
        return entrada.nextLine();
    }
}
