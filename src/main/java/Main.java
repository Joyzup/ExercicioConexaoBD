import model.Usuario;

import java.sql.SQLException;

public class Main {
    //Essa classe vai ser responsável pela execução da aplicação
    public static void main(String[] args) {
        ServiceUser serviceUser = new ServiceUsere();
        ServiceUser.consultatodososDadosBanco();

        ServiceUser.insereDadosBanco();

        ServiceUser.listarUsuariosCadastrados();
        serviceUser.consultarNomesBD;
    }


}
