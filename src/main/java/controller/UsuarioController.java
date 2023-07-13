package controller;

import service.UsuarioService;

import java.util.List;
import java.util.Scanner;

public class UsuarioController {
    private UsuarioService usuarioService;

    public void listarClientesMenu(){
        try{
            System.out.print("\n[---------------------------------]");
            System.out.print("\n Esses são os clientes cadastrados");
            System.out.print("\n[---------------------------------]\n");

            usuarioService.listandoTodosUsuario();

        } catch (Exception e){
            System.out.println("Ocorreu um erro ao buscar o cliente: " + e.getMessage());
        }
    }

    public void cadastrarUsuarioMenu() {
        System.out.println("\n[---------------------------------]");
        System.out.println("      Cadastro de Usuário");
        System.out.println("[---------------------------------]");

        System.out.print("Digite o CPF: ");
        String cpf = new Scanner(System.in).nextLine();

        System.out.print("Nome Completo: ");
        String nome = new Scanner(System.in).nextLine();

        System.out.print("E-mail: ");
        String email = new Scanner(System.in).nextLine();

        System.out.print("Telefone: ");
        String telefone = new Scanner(System.in).nextLine();

        try {
            usuarioService.adicionarUsuario(nome, cpf, email, telefone);
        } catch (RuntimeException e) {
            System.out.println("\n[--------------------------------------]");
            System.out.println("Error: Erro ao cadastrar usuário: " + e.getMessage());
            System.out.println("[--------------------------------------]");
        }
    }

    public void buscarClienteMenu() {
        try {
            System.out.print("\n[---------------------------------]");
            System.out.print("\n  Buscar o Cliente pelo CPF");
            System.out.print("\n[---------------------------------]\n");

            System.out.print("Digite o CPF do cliente: ");
            String cpfCliente = new Scanner(System.in).nextLine();

        } catch (Exception e){
            System.out.println("Ocorreu um erro ao listar os clientes: " + e.getMessage());
        }
    }
}
