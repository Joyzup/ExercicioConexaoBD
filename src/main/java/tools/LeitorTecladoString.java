package tools;

import java.util.Scanner;

public class LeitorTecladoString {
    private String valorDigitado;

    public String teclado(){
        Scanner entrada = new Scanner(System.in);

        valorDigitado = entrada.nextLine();
        return valorDigitado;
    }
}
