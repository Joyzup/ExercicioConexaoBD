import service.Comandos;
import service.Menu;

import java.util.Scanner;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {

        Menu menu = new Menu();
        Comandos comandos = new Comandos();

        Scanner resposta = new Scanner(System.in);

        System.out.println("Boas-vindas ao nosso bloco com os nomes dos nossos clientes ZupFood!");
        System.out.println("Aqui, só por curiosidade, armazenamos os primeiros nomes de quem já foi cliente nosso!");
        System.out.println("Evitamos sempre repetir nomes, então caso encontre algum nome repetido, por favor, exclua-o!");

        boolean rodando = true;

        while (rodando) {

            menu.MenuPrincipal();
            int selecao = resposta.nextInt();

            switch (selecao) {
                case 0:
                    rodando = false;
                    break;
                case 1:
                    comandos.consultarDados();
                    break;
                case 2:
                    System.out.println("Digite o nome que deseja inserir:");
                    resposta.nextLine();
                    String nome = resposta.nextLine();
                    comandos.inserirDados(nome);
                    break;
                case 3:
                    System.out.println("Diga qual o id do nome que deseja alterar:");
                    int id = resposta.nextInt();
                    System.out.println("Diga qual o novo nome que deseja:");
                    resposta.nextLine();
                    nome = resposta.nextLine();
                    comandos.atualizarDados(id, nome);
                    break;
                case 4:
                    System.out.println("Digite o id do nome que deseja remover:");
                    id = resposta.nextInt();
                    comandos.removerDados(id);
                    break;
                case 5:
                    System.out.println("Lista só com os nomes:");
                    comandos.consultarApenasNomes();
                    break;
            }

        }
    }
}
