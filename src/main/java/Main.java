import model.Usuario;
import service.ServicoUsuario;

import java.util.Scanner;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação

    public static void main(String[] args) {

        ServicoUsuario servicoUsuario = new ServicoUsuario();

        System.out.println("-----------------------------------------------------");
        System.out.println("                   BANCO DE DADOS                    ");
        System.out.println("-----------------------------------------------------");

        Scanner sc = new Scanner(System.in);
        Usuario usuario = new Usuario();
        boolean operarMenu = true;

        do {
            String escolhaUsuario = menuExibir();
            switch (escolhaUsuario){
                case "1":
                    servicoUsuario.consultarRegistros();
                    break;

                case "2":
                    System.out.println("Qual o nome do usuário?");
                    String nome = sc.next();
                    usuario.setNome(nome);

                    servicoUsuario.inserirRegistro(usuario.getNome());
                    break;

                case "3":
                    System.out.println("Qual id do usuário que deseja alterar?:");
                    Integer id = sc.nextInt();
                    System.out.println("Escreva o nome alterado:");
                    String atualizarDados = sc.next();
                    usuario.setNome(atualizarDados);

                    servicoUsuario.alterarRegistro(usuario.getNome(), id);
                    break;

                case "4":
                    System.out.println("Qual ID deseja excluir?:");
                    Integer deletarDados = sc.nextInt();

                    servicoUsuario.excluir(deletarDados);
                    break;

                case "5":
                    servicoUsuario.nomesCadastrados();
                    break;

                case "6":
                    operarMenu = false;
                    System.out.println("Obrigado(a) por utilizar nosso sistema, até logo!");
                    break;
            }
        } while (operarMenu);

    }

    public static String menuExibir(){
        Scanner sc = new Scanner(System.in);
        System.out.println("| 1 - Consultar todos os dados da tabela            |");
        System.out.println("| 2 - Inserir novos dados na tabela                 |");
        System.out.println("| 3 - Atualizar dados na tabela                     |");
        System.out.println("| 4 - Deletar dados da tabela                       |");
        System.out.println("| 5 - Consultar coluna nomes                        |");
        System.out.println("| 6 - Sair                                          |");
        System.out.println("-----------------------------------------------------");
        return sc.nextLine();
    }
}

