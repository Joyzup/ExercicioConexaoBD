import model.Usuario;
import service.ServiceUser;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.Executor;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

        Usuario usuario = new Usuario();
        String menuOpcao, nome , alterarNome;
        Integer id, idExcluir;

        ServiceUser serviceUser = new ServiceUser();

        System.out.println("===============================");
        System.out.println("=========== ZUPFood ===========");


        boolean continuar = true;

        do {
            menuOpcao = exibirMenu();
            switch (menuOpcao) {
                case "1" :
                    serviceUser.consultaDados();
                    break;
                case "2" :
                    System.out.println("Para inserir usuário informe o nome: ");
                    nome = entrada.next();
                    break;
                case "3" :
                    System.out.println("Para alterar o nome informe o ID: ");
                    id = entrada.nextInt();
                    System.out.println("Novo nome: ");
                    alterarNome = entrada.next();
                    usuario.setNome(alterarNome);
                case "4" :
                    System.out.println("Para excluir usuário informe o ID: ");
                    idExcluir = entrada.nextInt();

                    serviceUser.excluirDados(idExcluir);
                    break;
                case "5" :
                    serviceUser.consultarNome();
                    break;
                case "6" :
                    continuar = false;
                    System.out.println("Sair do programa.");
                    break;

            }
        } while (continuar);



    }

    private static String exibirMenu() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("===============================");
        System.out.println("===Escolha a opção desejada====");
        System.out.println("=== #1 - Consultar usuário ====");
        System.out.println("=== #2 - Cadastrar usuário ====");
        System.out.println("=== #3 - Atualizar usuário ====");
        System.out.println("=== #4 - Deletar usuário ======");
        System.out.println("=== #5 - Consultar nomes ======");
        System.out.println("=== #6 - Sair do programa =====");
        System.out.println("===============================");
        return entrada.nextLine();
    }
}
