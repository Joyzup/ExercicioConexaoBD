import controller.Controller;
import service.Comandos;
import service.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {

        Menu menu = new Menu();
        Controller controller = new Controller();

        System.out.println("Boas-vindas ao nosso bloco com os nomes dos nossos clientes ZupFood!");
        System.out.println("Aqui, só por curiosidade, armazenamos os primeiros nomes de quem já foi cliente nosso!");
        System.out.println("Evitamos sempre repetir nomes, então caso encontre algum nome repetido, por favor, exclua-o!");

        boolean rodando = true;

        while (rodando) {

            try {
                menu.MenuPrincipal();
                int selecao = new Scanner(System.in).nextInt();

                switch (selecao) {
                    case 0:
                        rodando = false;
                        controller.sairPrograma();
                        break;
                    case 1:
                        controller.consultarDados();
                        break;
                    case 2:
                        controller.inserirDados();
                        break;
                    case 3:
                        controller.atualizarDados();
                        break;
                    case 4:
                        controller.removerDados();
                        break;
                    case 5:
                        controller.consultarSomenteNomes();
                        break;
                    default:
                        System.out.println("");
                        System.out.println("Entrada inválida");
                        System.out.println("");
                }
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("Entrada inválida");
                System.out.println("");
            }

        }
    }
}
