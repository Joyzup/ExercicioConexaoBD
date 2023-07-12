import service.MenuService;
import service.QueryService;

public class Main {
  //Essa classe vai ser responsável pela execução da aplicação
  public static void main(String[] args) {
    MenuService menu = new MenuService();
    menu.interacaoUsuario();
  }
}
