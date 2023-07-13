import service.ExecutarService;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {

        ExecutarService executarService = new ExecutarService();
        executarService.consultarBD();
        executarService.inserirDados();
        executarService.alterarDados();

        executarService.inserirDados();
        executarService.consultarNome();

        executarService.consultarBD();

        executarService.deletarDados();






        //Conexão com o banco de dados

//        try {
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testebancodedados",
//                    "postgres", "Postgres@1982");
//
//            if (connection != null) {
//                System.out.println("|--------------------------------------------------|");
//                System.out.println("| Conexão ao Banco de Dados realizada com sucesso! |");
//                System.out.println("|--------------------------------------------------|");
//                Statement statement = connection.createStatement();
//
//
//
//                consultarBD(statement);
//                inserirDados(statement);
//                alterarDados(statement);
//                inserirDados(statement);
//                consultarNome(statement);
//
//                consultarBD(statement);
//
////               deletarDados(statement);
//
//            } else {
//                System.out.println("|------------------------------------------|");
//                System.out.println("| Conexão ao banco de dados não realizada! |");
//                System.out.println("|------------------------------------------|");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    //Manipular o banco de dados e método para consultar o banco de dados
//    static void consultarBD(Statement statement) {
//        //consulta por completo o BD
//        String sql = "SELECT * FROM usuarios";
//        try {
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                System.out.println("ID: " + rs.getInt("id_usuario") + " - Nome: "
//                        + rs.getString("nome") + " - Idade: " + rs.getInt("idade") + " anos.");
//            }
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }

//    }
    //método para inserir dados
//    static void inserirDados(Statement statement){
//        String sql = "INSERT INTO usuarios (nome, idade) VALUES " + "('Gabriel Lopes', 30), " + "('João Pedro', 25)";
//        try {
//            statement.executeUpdate(sql);
//            System.out.println("Dados inseridos com sucesso!");
//            System.out.println();
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//        }

        //método para alterar dados da tabela do BD
//    static void alterarDados(Statement statement){
//        String sql = "UPDATE usuarios SET nome = 'João Henrique' WHERE id_usuario = 1";
//        try {
//            statement.executeUpdate(sql);
//            System.out.println("Dados alterados com sucesso!");
//            System.out.println();
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    //método para deletar dados da tabela do BD
//    static void deletarDados(Statement statement){
//        String sql = "DELETE FROM usuarios WHERE id_usuario BETWEEN 8 AND 30";
//        try {
//            statement.executeUpdate(sql);
//            System.out.println("Dados ID entre 8 e 30 - deletados com sucesso!");
//            System.out.println();
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//método para consultar campo nome da tabela do BD
//    static void consultarNome(Statement statement){
//        String sql = "SELECT nome FROM usuarios";
//        try {
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                System.out.println("Nome: " + rs.getString("nome"));
//                System.out.println();
//            }
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    }
