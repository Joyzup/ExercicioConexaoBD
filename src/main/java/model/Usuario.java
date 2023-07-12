package model;

//Tabela do nosso banco
public class Usuario {

    //Atributos = Colunas do banco

    private Long id_usuario;
    private String nome;
    private int idade;

    //CONSTRUCTOR
    public Usuario(Long id_usuario, String nome, int idade) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.idade = idade;
    }

    public Usuario() {
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "\nID DO USUÁRIO: " + id_usuario + " | NOME: " + nome + " | IDADE: " + idade + "\n";

    }
}
