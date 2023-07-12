package service;

import java.util.Scanner;

public class MenuService {
  Scanner inputUsuario = new Scanner(System.in);
  QueryService query = new QueryService();
  boolean menu = true;

  public void interacaoUsuario() {
    do {
      menuUsuario();
      int opcao = inputUsuario.nextInt();
      switch (opcao) {
        case 1:
          query.consultaTodosDadosBanco();
          break;
        case 2:
          query.consultaNomesBanco();
          break;
        case 3:
          System.out.println("Informe o nome: ");
          String nome = inputUsuario.next();
          query.insereDadosBanco(nome);
          break;
        case 4:
          System.out.println("Informe o nome que desejsa substituir e o novo nome: ");
          nome = inputUsuario.next();
          String novoNome = inputUsuario.next();
          query.atualizaDadosBanco(nome, novoNome);
          break;
        case 5:
          System.out.println("Informe o id que deseja deletar");
          int id = inputUsuario.nextInt();
          query.deletaDadosBanco(id);
          break;
        case 6:
          menu = false;
          System.out.println("Encerrando aplicação....");
          break;
        default:
          System.out.println("Opção inválida!!");
      }
    } while (menu);

  }
  public static void menuUsuario() {
    System.out.println("\nQual operação deseja realizar? " +
        "\n1 - Consulte todos os dados da tabela " +
        "\n2 - Consulte somente a coluna nomes da tabela" +
        "\n3 - Insira dados na tabela " +
        "\n4 - Atualize dados na tabela " +
        "\n5 - Delete dados na tabela" +
        "\n6 - Sair");
  }
}






