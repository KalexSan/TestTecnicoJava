package Quest05;

import java.util.Scanner;

public class InvCaractre {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um caractere: ");
        String caractere = scanner.nextLine();


        String invertido = inverterString(caractere);

        System.out.println("String invertido: " + invertido);
        scanner.close();
    }

    public static String inverterString(String caractere) {
        String invertido = "";
        for (int i = caractere.length() - 1; i >= 0; i--) {
            invertido += caractere.charAt(i);
        }
        return invertido;
    }
}
