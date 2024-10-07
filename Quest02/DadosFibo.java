package Quest02;

import java.util.Scanner;

public class DadosFibo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int num = scanner.nextInt();

        if (pertenceFibo(num)) {
            System.out.println("O número " + num + " pertence á sequéncia de Fibonacci.");
    
        } else {
            System.out.println("O número " + num + " não pertence á sequéncia de Fibonacci.");
        }
        scanner.close();
    }

    public static boolean pertenceFibo(int num) {
        if (num == 0 || num == 1) {
            return true;
        
        }

        int a = 0, b = 1, c = 0;
        while (c < num) {
            c = a + b;
            a = b;
            b = c;
        }

        return c == num;
    }
}